package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * nio test
 * Created by victor on 16/3/13.
 */
public class Server implements Runnable {

    public static void main(String[] args) {
        new Thread(new Server()).start();
    }


    @Override
    public void run() {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress("localhost", 9090));
            Selector selector = Selector.open();
            //| SelectionKey.OP_READ | SelectionKey.OP_WRITE
            serverChannel.register(selector, SelectionKey.OP_ACCEPT );
            while (true) {
                selector.select();
                System.out.println("found events in the queue");
                System.out.println(selector.selectedKeys());
                Set<SelectionKey>      selectedKeys         = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeysIterator = selectedKeys.iterator();
                while (selectionKeysIterator.hasNext()) {
                    SelectionKey selectionKey = selectionKeysIterator.next();
                    selectionKeysIterator.remove();
                    System.out.println("selectionKey:" +selectionKey);
                    System.out.println("selectionKey's channel:" +selectionKey.channel());
                    System.out.println("selectionKey's channel isOpen:" +selectionKey.channel().isOpen());
                    if (!selectionKey.isValid()) {
                        selectionKey.cancel();
                        continue;
                    }

                    if (selectionKey.isAcceptable()) {
                        System.out.print("accept event fired on selector,");
                        SocketChannel socketChannel = serverChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println("channel: " + socketChannel);
                    } else if (selectionKey.isConnectable()) {
                        System.out.print("connect event fired on selector,");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        System.out.println("channel: " + socketChannel);
                    } else if (selectionKey.isReadable()) {
                        System.out.print("read event fired on selector,");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer    byteBuffer    = ByteBuffer.allocate(48);
                        int           size          = socketChannel.read(byteBuffer);
                        if (size > 0) {
                            byte[] bytes = new byte[size];
                            byteBuffer.get(bytes);
                            System.out.print("read: " + new String(bytes) + ",");
                        }
                        socketChannel.close();
                        System.out.println("channel: " + socketChannel);
                    } else if (selectionKey.isWritable()) {
                        System.out.print("write event fired on selector,");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        String str = "haha";
                        System.out.print("write: " + str + ",");
                        ByteBuffer byteBuffer = ByteBuffer.allocate(str.getBytes().length);
                        byteBuffer.put(str.getBytes());
                        socketChannel.write(byteBuffer);
                        System.out.println("channel: " + socketChannel);
                    }

                }
            }
            //Selector s = SelectorProvider.provider().openSelector();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
