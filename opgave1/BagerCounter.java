package opgave1;

import java.util.Random;

public class BagerCounter {
    private int lastIssued;
    private int lastCalled;
//    private int peopleWaiting = lastIssued - lastCalled;


    public static void tagerRanTid (int max) {
        int x, y;
        Random r = new Random(1023);
        int max2 = Math.abs(r.nextInt() % max + 1);
        for (int i = 0; i < max2; i++) {
            for (int j = 0; j < max2; j++) {
                x = i + j;
                y = i - j;
            }
        }
    }
}
