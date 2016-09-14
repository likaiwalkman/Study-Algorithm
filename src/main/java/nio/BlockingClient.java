package nio;

import java.io.*;
import java.util.concurrent.*;

public class BlockingClient {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, IOException {
        /*OutputStream fos = new FileOutputStream("D:/out.txt");
        System.setOut(new PrintStream(fos));*/

        int concurrentSize = 1;
        ExecutorService executorService = Executors.newFixedThreadPool(concurrentSize);

        CyclicBarrier barrier = new CyclicBarrier(concurrentSize+1);
        for (int i = 0; i < concurrentSize; i++) {
            executorService.submit(new BlockingClientRequest(barrier));
        }

        long timestamp = System.currentTimeMillis();
        //start to fire all tasks to run
        if (Settings.BLOCKING_SWITCH) {
            barrier.await();
        }

        //when all tasks is over, notify main thread
        if (Settings.BLOCKING_SWITCH) {
            barrier.await();
        }

        executorService.shutdown();
        //executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("Client over, task count:" + concurrentSize +", time elapsed : " + (System.currentTimeMillis() - timestamp) + "ms" );
        //fos.close();

    }
}
