package com.ashish.java.learn.java11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class StudentClient {

    HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(2)).build();

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    public static String ALL_STUDENTS_URL = "http://127.0.0.1:8000/src/main/resources/student.json";

    public List<Student>  getStudents() {
        HttpRequest httpRequest = httpRequestBuilder(ALL_STUDENTS_URL);
        try {
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), new TypeReference<List<Student>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudentsAsync() {
        HttpRequest httpRequest = httpRequestBuilder(ALL_STUDENTS_URL);
        try {
            CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture =
                    client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

            return httpResponseCompletableFuture.thenApply(httpResponse -> {
                System.out.println("Status code as :: " + httpResponse.statusCode());
                try {
                    return objectMapper.readValue(httpResponse.body(), new TypeReference<List<Student>>() {});
                } catch (Exception e) {
                    throw new RuntimeException("Failed to parse response", e);
                }
            }).join(); // To make it synchronous. Remove `.join()` if fully async.
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error during HTTP request", e);
        }
    }

    public static HttpRequest httpRequestBuilder(String url)    {
        return HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
    }
}
