package lock.juc;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(2);
        new Task(latch).start();
        new Task(latch).start();

        new Coordinator(latch).start();
        new Coordinator(latch).start();

        synchronized (Test.class){
            Test.class.wait();
        }

    }
}
