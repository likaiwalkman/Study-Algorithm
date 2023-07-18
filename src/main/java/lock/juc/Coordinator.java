package lock.juc;

import java.util.concurrent.CountDownLatch;

public class Coordinator extends Thread {
    private CountDownLatch latch;

    public Coordinator(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("action");
        }catch (Exception e){

        }
    }
}
