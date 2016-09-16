package nio.onebyte;

import nio.Settings;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws Exception {
        Selector selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(new InetSocketAddress("localhost", 9090));
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        int count = 0;

        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey sk = keyIterator.next();
                keyIterator.remove();



                if (sk.isAcceptable()) {
                    if ((++count) == 3) {
                        //System.exit(0);
                    }

                    SocketChannel socketChannel = serverChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                }

                if (sk.isReadable()) {
                    SocketChannel channel = (SocketChannel) sk.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1);
                    int read = channel.read(buffer);
                    if (read > 0) {
                        buffer.flip();
                        byte b = buffer.get();
                        System.out.println("read:"+b);
                        System.out.println("------");
                    }
                }

                if (sk.isWritable()) {
                    SocketChannel channel = (SocketChannel) sk.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1);
                    byte       b      = (byte) (System.currentTimeMillis() % 2 == 0 ? 0 : 1);
                    buffer.put(b);
                    buffer.flip();
                    int write = channel.write(buffer);
                    if (write > 0) {
                        System.out.println("write:"+b);
                        System.out.println("------");
                    }
                }
            }
        }
    }
}
