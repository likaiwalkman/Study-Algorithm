package nio;

import java.io.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, IOException {
        /*OutputStream fos = new FileOutputStream("D:/out.txt");
        System.setOut(new PrintStream(fos));*/

        int concurrentSize = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(concurrentSize);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(concurrentSize+1);
        for (int i = 0; i < concurrentSize; i++) {
            executorService.submit(new ClientRequest(cyclicBarrier));
        }

        //start to fire all tasks to run
        cyclicBarrier.await();

        //when all tasks is over, notify main thread
        cyclicBarrier.await();

        System.out.println("Client over");
        executorService.shutdownNow();
        //fos.close();

    }
}
