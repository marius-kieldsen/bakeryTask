package opgave2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BagerCounter2 {
    private volatile int lastIssued;
    private Queue<Integer> queue = new LinkedList<>();

    volatile boolean flag[] = new boolean[]{false, false};
    volatile int turn;


    public void setFlag(boolean flag, int id) { this.flag[id] = flag; }
    public boolean getFlag(int id) { return flag[id]; }
    public void setTurn(int turn) { this.turn = turn; }
    public int getTurn() { return turn; }

    public int takeNumber() {
        lastIssued++;
        queue.add(lastIssued);
        System.out.println("Kunde trak nr. " + lastIssued + " | Udleveret i alt: " + lastIssued);
        return lastIssued;
    }

    public void callNext() {
        if (!queue.isEmpty()) {
            int number = queue.poll();
            System.out.println("Ekspedient råber nr. " + number + " op | Kø: " + queue.size());
        }
    }

    public int getWaiting() { return queue.size(); }

    public static void tagerRandomTid(int max) {
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
