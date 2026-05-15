package opgave1;

//    EN INSTANS AF DENNE
public class EkspedientTråd extends Thread {
    private BagerCounter counter;
    private int antalKunder;

    public EkspedientTråd (BagerCounter counter,  int antalKunder) {
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
                BagerCounter.tagerRandomTid(100);
            }
        }
    }
}
