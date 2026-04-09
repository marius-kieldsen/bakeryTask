package opgave2;

//    EN INSTANS AF DENNE
public class EkspedientTråd2 extends Thread {
    private BagerCounter2 counter;
    private int antalKunder;

    public EkspedientTråd2(BagerCounter2 counter, int antalKunder) {
        this.counter = counter;
        this.antalKunder = antalKunder;
    }

    @Override
    public void run() {
        int betjent = 0;
        while (betjent < antalKunder) {
            if (counter.getWaiting() > 0) {
                counter.callNext();
                betjent++;

                // venter tilfældig mændge tid
                BagerCounter2.tagerRandomTid(100);
            }
        }
    }
}
