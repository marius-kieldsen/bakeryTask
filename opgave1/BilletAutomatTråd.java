package opgave1;

//    TO INSTANSER AF DENNE
public class BilletAutomatTråd extends Thread {
    private int nummerCapacitet;
    private BagerCounter counter;
    private int thisId;
    private int concurrentId;

    public BilletAutomatTråd(BagerCounter counter, int kundeCapacitet, int thisId) {
        this.counter = counter;
        this.nummerCapacitet = kundeCapacitet / 2;
        this.thisId = thisId;
    }

    @Override
    public void run() {
        concurrentId = (thisId + 1) % 2;

        for (int i = 0; i < nummerCapacitet; i++) {
            // Peterson's
            counter.setFlag(true, thisId);
            counter.setTurn(concurrentId);
            while (counter.getFlag(concurrentId) && counter.getTurn() == concurrentId){
                // busy wait
            }

            // Critical Region
            counter.takeNumber();

            // Forlad Critical Region
            counter.setFlag(false, thisId);

            // venter tilfældig mændge tid
            BagerCounter.tagerRandomTid(100);

        }
    }

}
