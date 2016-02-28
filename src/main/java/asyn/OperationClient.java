package asyn;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OperationClient {

    // Charset and decoder for US-ASCII
//    private static Charset charset = Charset.forName("US-ASCII");

    // Direct byte buffer for reading
//    private static ByteBuffer dbuf = ByteBuffer.allocateDirect(1024);

    // Ask the given host what time it is
    //
    private static void query(String host, int port) throws Exception {
        Charset           charset    = Charset.forName("US-ASCII");
        ByteBuffer        dbuf       = ByteBuffer.allocateDirect(1024);
        byte              inBuffer[] = new byte[100];
        InetSocketAddress isa        = new InetSocketAddress(InetAddress.getByName(host), port);
        SocketChannel     sc         = null;
        while (true) {
            try {
                //System.in.read(inBuffer);
                inBuffer = "2,3".getBytes();
                System.out.println("zzzzzzzzzzzzz");
                sc = SocketChannel.open();
                sc.connect(isa);
                dbuf.clear();
                dbuf.put(inBuffer);
                dbuf.flip();
                sc.write(dbuf);
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                buffer.clear();
                sc.read(buffer);
                buffer.flip();
                System.out.println(new String(buffer.array()).trim());
                dbuf.clear();

            } finally {
                // Make sure we close the channel (and hence the socket)
                Thread.sleep(10 * 60 * 1000);
                if (sc != null) sc.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        query("localhost", 8090);//A+B
        int                  size       = 10;
        ExecutorService      exeService = Executors.newFixedThreadPool(size);
        final CountDownLatch latch      = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            exeService.submit(new Runnable() {
                public void run() {
                    try {
                        //System.out.println("ready to go");
                        latch.await();
                        query("localhost", 8090);//A+B
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("main to go");
        for (int i = 0; i < size; i++) {
            latch.countDown();
        }
//        query("localhost", 9090);//A*B
    }
}
