package lock.juc;

import java.util.concurrent.CountDownLatch;

public class Task extends Thread{
    private CountDownLatch latch;

    public Task(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.countDown();
            System.out.println("latch release");
        }catch (Exception e){

        }
    }
}
