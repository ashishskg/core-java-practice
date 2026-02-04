package com.ashish.java.learn.java11;

import java.util.List;

public class StudentClientApp {
    // To Run the application
    // Step 1: Go to command prompt and run the web server with below command
    // /Library/Java/JavaVirtualMachines/jdk-23.jdk/Contents/Home/bin/jwebserver
    // Step 2: Hit this URL
    // http://127.0.0.1:8000/src/main/resources/student.json

    public static void main(String[] args) {
        StudentClient studentClient = new StudentClient();
        List<Student> students = studentClient.getStudents();
        students.forEach(System.out::println);

//        Student[name=Tom, age=24, course=B Tech]
//        Student[name=Bob, age=26, course=MCA]

        // Asynchronous call
        StudentClient studentClient1 = new StudentClient();
        List<Student> students1 = studentClient.getStudentsAsync();
        students.forEach(System.out::println);
    }
}
