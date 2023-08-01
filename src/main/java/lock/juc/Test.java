package lock.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.shutdownNow();
        executorService.shutdown();
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
