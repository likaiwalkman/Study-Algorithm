package asyn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by victor on 16/3/1.
 */
public class NioTest {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousSocketChannel ayncSocketChannel = AsynchronousSocketChannel.open();
        Future future = ayncSocketChannel.connect(new InetSocketAddress("localhost", 8080));
        if (future.get()!=null) {
            System.out.println("link success");
        }
    }
}
