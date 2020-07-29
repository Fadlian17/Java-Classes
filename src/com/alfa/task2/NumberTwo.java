package com.alfa.task2;


public class NumberTwo {

    public static void main(String[] args) {
        System.out.printf("==Number 2==\n");
        LengthWord("aku");
        LengthWord("ingin");
        LengthWord("la...");

    }
    private static void LengthWord(String words){
        // teks string yang diperiksa
        var lyric = "Aku ingin begini\n" +
                "Aku ingin begitu\n" +
                "Ingin ini itu banyak sekali\n\n" +
                "Semua semua semua\n" +
                "Dapat dikabulkan\n" +
                "Dapat dikabulkan\n" +
                "Dengan kantong ajaib\n\n" +
                "Aku ingin terbang bebas\n" +
                "Di angkasa\n" +
                "Hei… baling baling bambu\n\n" +
                "La... la... la...\n" +
                "Aku sayang sekali\n" +
                "Doraemon\n\n" +
                "La... la... la...\n" +
                "Aku sayang sekali";
        var lowerCase = lyric.replace("\n", " ").toLowerCase();

        System.out.println(" Kata "+words+" berjumlah "+LogicWords(lowerCase, words));
    }

     static int LogicWords(String str,String words){
        String[] a = str.split(" ");

        int count = 0;
        for (String s : a) {
            if (words.equals(s))
                count++;
        }

        return count;
    }

}
