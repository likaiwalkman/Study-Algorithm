package nio.line;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws IOException, BrokenBarrierException, InterruptedException {
        int con = 20;
        CyclicBarrier barrier = new CyclicBarrier(con+1);
        ExecutorService executor = Executors.newFixedThreadPool(con);

        for (int i = 0; i < con; i++) {
            Run run = new Run(barrier);
            executor.submit(run);
        }
        barrier.await();
        executor.shutdown();
        executor.awaitTermination(50, TimeUnit.SECONDS);
    }
    static class Run implements Runnable{
        CyclicBarrier barrier;
        public Run(CyclicBarrier barrier){
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            Socket socket = new Socket();
            try {
                socket.connect(new InetSocketAddress("localhost", 8009));
                socket.getOutputStream().write("hello.".getBytes());
                InputStream inputStream = socket.getInputStream();
                int read;
                StringBuilder builder = new StringBuilder();
                while ((read = inputStream.read()) != -1) {
                    builder.append((char) read);
                }
                System.out.println(builder);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
