package opgave2;

import opgave2.EkspedientTråd2;
import opgave2.BilletAutomatTråd2;
import opgave2.BagerCounter2;

public class Main2 {
    public static void main(String[] args) {
        int kundeCapacitet = 20;
        BagerCounter2 counter = new BagerCounter2();

        BilletAutomatTråd2 billetAutomat1 = new BilletAutomatTråd2(counter, kundeCapacitet, 0);
        BilletAutomatTråd2 billetAutomat2 = new BilletAutomatTråd2(counter, kundeCapacitet, 1);
        EkspedientTråd2 ekspedient = new EkspedientTråd2(counter, kundeCapacitet);


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
