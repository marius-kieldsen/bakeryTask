package opgave1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random ankomst = new Random();

        int tal = ankomst.nextInt(0, 3);

        System.out.println(tal);

        int max = 30000;

        long startTid = System.nanoTime();

        long slutTid = System.nanoTime();

        System.out.println("Køretid: " + (slutTid - startTid) / 1_000_000 + " ms");
    }
}
