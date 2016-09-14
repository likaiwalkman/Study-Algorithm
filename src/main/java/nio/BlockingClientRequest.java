package nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;

public class BlockingClientRequest implements Runnable {
    CyclicBarrier barrier;

    public BlockingClientRequest(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            if (Settings.BLOCKING_SWITCH) {
                barrier.await();
            }
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(Settings.SERVER_HOST, Settings.SERVER_PORT));
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

            //Thread.sleep(5000);
            socket.shutdownInput();
            socket.shutdownOutput();

            if (Settings.BLOCKING_SWITCH) {
                barrier.await();
            }
            System.out.println("ThreadId: "+Thread.currentThread().getId() +", request over, lastRead:" + read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
