package com.ashish.java.inaction.chap3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
public class ExecuteAround {

	public static void main(String ...args) throws IOException{
		String result = "";
        // method we want to refactor to make more flexible
		try {
			result = processFileLimited();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        System.out.println(result);

        System.out.println("---");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);

	}

    public static String processFileLimited() throws IOException {
        try (InputStream is = Objects.requireNonNull(ExecuteAround.class.getClassLoader().getResourceAsStream("com/ashish/java/inaction/chap3/data.txt"));
             BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            return br.readLine();
        }
        
    }


	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (InputStream is = Objects.requireNonNull(ExecuteAround.class.getClassLoader().getResourceAsStream("com/ashish/java/inaction/chap3/data.txt"));
		     BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
			return p.process(br);
		}

	}

	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;

	}
}
