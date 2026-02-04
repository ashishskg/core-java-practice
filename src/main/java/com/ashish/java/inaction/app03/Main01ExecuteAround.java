package com.ashish.java.inaction.app03;

import java.io.*;
import java.net.URL;

public class Main01ExecuteAround {

    public static void main(String ...args) throws IOException{
        String result = "";
        try {
            result = ExecuteAround.processFileLimited();
            System.out.println("result :: " + result);
            // result :: Java
        } catch (Exception e) {
            e.printStackTrace();
        }

        String oneLine = ExecuteAround.processFile((BufferedReader b) -> b.readLine());
        System.out.println("oneLine :: " + oneLine);
        // oneLine :: Java

        String twoLines = ExecuteAround.processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println("twoLines :: " + twoLines);
        // twoLines :: Java8
    }
}

class ExecuteAround {
    public static String processFileLimited() throws IOException {
        try {
            URL resource = ExecuteAround.class.getClassLoader().getResource("data.txt");
            File file = new File(resource.getFile());
            BufferedReader br = new BufferedReader(new FileReader(file));
            return br.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try {
            URL resource = ExecuteAround.class.getClassLoader().getResource("data.txt");
            File file = new File(resource.getFile());
            BufferedReader br = new BufferedReader(new FileReader(file));
            return p.process(br);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public interface BufferedReaderProcessor{
        public String process(BufferedReader b) throws IOException;
    }
}