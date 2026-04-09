package opgave1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int kundeCapacitet = 20;
        BagerCounter counter = new BagerCounter();

        BilletAutomatTråd billetAutomat1 = new BilletAutomatTråd(counter, kundeCapacitet, 0);
        BilletAutomatTråd billetAutomat2 = new BilletAutomatTråd(counter, kundeCapacitet, 1);
        EkspedientTråd ekspedient = new EkspedientTråd(counter, kundeCapacitet);


        long startTid = System.nanoTime();

        billetAutomat1.start();
        billetAutomat2.start();
        ekspedient.start();

        try {
            billetAutomat1.join();
            billetAutomat2.join();
            ekspedient.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long slutTid = System.nanoTime();
        System.out.println("Køretid: " + (slutTid - startTid) / 1_000_000 + " ms");
    }
}
