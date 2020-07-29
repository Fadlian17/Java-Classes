package com.alfa.task2;

public class NumberTwo {
    public static void main(String[] args) {
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
        var jumlah = 0;
        var jumlah1 = 0;// jumlah kata awal
        var indeks = -1;  // posisi indeks awal
        var kata = "La...";
        var kata2 = "Aku";

        // Mencari kata "yang"
        indeks = lyric.indexOf(kata);
        while (indeks >= 0) {
            ++jumlah1;
            indeks += kata.length();
            indeks = lyric.indexOf(kata, indeks);
        }
        indeks = lyric.indexOf(kata2);
        while (indeks >= 0) {
            ++jumlah;
            indeks += kata.length();
            indeks = lyric.indexOf(kata, indeks);
        }
        System.out.println(lyric);
        System.out.println();
        System.out.println("Teks berisi kata: " + "\n" + "La... = " + jumlah1);
        System.out.println("Teks berisi kata: " + "\n" + "aku = " + jumlah);
    }
}
