package com.alfa.task2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NumberFive {

    static String[] headers(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine().split(",");
        }
    }

    private static List<Map<String, String>>ChangeJson() throws IOException {
        String path = "src/com/alfa/task2/files/data.csv";

// Read headers
        String[] headers = headers(path);

        List<Map<String, String>> result = null;

// Read data
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            result = stream
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(data -> {
                        Map<String, String> map = new HashMap<>();
                        for (int i = 0; i < data.length; i++) {
                            map.put(headers[i], data[i]);
                        }
                        return map;
                    })
                    .collect(Collectors.toList());

           return result;
        }
    }



    private static void writeJson() throws IOException {
        FileOutputStream fos = null;
        File file;
        String mycontent = String.valueOf(ChangeJson());
        try {
            file = new File("src/com/alfa/task2/files/product.json");
            fos = new FileOutputStream(file);

            if (!file.exists()) {
                file.createNewFile();
            }

            byte[] bytesArray = mycontent.getBytes();

            fos.write(bytesArray);
            fos.flush();
            System.out.println("File Written Successfully");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            try {
                if (fos != null)
                {
                    fos.close();
                }
            }
            catch (IOException ioe) {
                System.out.println("Error in closing the Stream");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.printf("==Number 5==\n");
        writeJson();
    }
}
