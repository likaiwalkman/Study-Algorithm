package nio;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;

public class ClientRequest implements Runnable {
    CyclicBarrier barrier;

    public ClientRequest(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            barrier.await();
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 9090));
            socket.getOutputStream().write((byte) 1);

            InputStream ins = socket.getInputStream();
            int read = -1;
            int count = 0;
            //int errCount = 0;
            while ((++count <= Settings.count)) {
                read = ins.read();
                if (read == -1) {
                    count--;
                    //Thread.sleep(100);
                    System.out.println("ThreadId: "+Thread.currentThread().getId() + ", read:" + read + ", count:" + count +", time:"+new Date()+", timeMills : "+ System.currentTimeMillis());
                    continue;
                }
                System.out.println("ThreadId: "+Thread.currentThread().getId() + ", read:" + read + ", count:" + count +", time:"+new Date()+", timeMills : "+ System.currentTimeMillis());
            }
            System.out.println("request over, read:" + read);
            //Thread.sleep(5000);
            socket.shutdownInput();
            socket.shutdownOutput();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
