package com.alfa.task2;


import java.io.FileInputStream;

public class NumberFour {
    public static void main(String[] args) {
        System.out.printf("==Number 4==\n");
        showName();
        showRange();

    }

    private static void showRange() {
        try {
            var inputStream = new FileInputStream("src/com/alfa/task2/files/file.json");
            System.out.println("range value 50 - 100."+new String(inputStream.readAllBytes()));
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void showName() {
        try {
            var inputStream = new FileInputStream("src/com/alfa/task2/files/file.json");
            System.out.println("name by 'berry'"+new String(inputStream.readAllBytes()));
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}



