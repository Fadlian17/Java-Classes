package com.alfa.task2;

import java.io.*;
import java.util.ArrayList;


public class NumberFive {
    public static void main(String[] args) {
        String csvFile = "src/com/alfa/task2/files/data.csv";
        DataInputStream myInput;
        String thisLine;
        ArrayList<ArrayList<String>> arList = new ArrayList<ArrayList<String>>();
        ArrayList<String> al = new ArrayList<String>();
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(csvFile);
            myInput = new DataInputStream(fis);
            while ((thisLine = myInput.readLine()) != null) {
                al = new ArrayList<String>();
                String strar[] = thisLine.split("\\|");
                for (int j = 0; j < strar.length; j++) {
                    System.out.println(strar[j].toString());
                    al.add(strar[j]);
                }
            }
            arList.add(al);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println("Done");
    }


//    public static class GetJson(){
//        public String name,category;
//        public int price;
//    }
}
