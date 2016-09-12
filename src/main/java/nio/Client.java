package nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException, FileNotFoundException {
        /*OutputStream fos = new FileOutputStream("D:/out.txt");
        System.setOut(new PrintStream(fos));*/

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        executorService.submit(new ClientRequest(cyclicBarrier));
        executorService.submit(new ClientRequest(cyclicBarrier));
        cyclicBarrier.await();
        executorService.shutdown();
        //System.exit(0);

    }
}
