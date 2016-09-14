package nio;

import org.apache.commons.codec.binary.Hex;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

/**
 * nio test
 * Created by victor on 16/3/13.
 */
public class Server implements Runnable {

    Map<SelectionKey, ByteBuffer> responseContext = new HashMap<SelectionKey, ByteBuffer>();
    Map<SelectionKey, Integer> writeBookmarks = new HashMap<SelectionKey, Integer>();
    Map<SelectionKey, Integer> readBookmarks = new HashMap<SelectionKey, Integer>();

    public static void main(String[] args) {
        new Thread(new Server()).start();
    }

    public void run() {
        try {
            bind();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bind() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(new InetSocketAddress(Settings.SERVER_HOST, Settings.SERVER_PORT));
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            if (selectedKeys.size()>0) {
                eventLoop(serverChannel, selector, selectedKeys);
            }
        }
    }

    private void eventLoop(ServerSocketChannel serverChannel, Selector selector, Set<SelectionKey> selectedKeys) throws IOException {

        Iterator<SelectionKey> selectionKeysIterator = selectedKeys.iterator();
        while (selectionKeysIterator.hasNext()) {
            SelectionKey selectionKey = selectionKeysIterator.next();
            selectionKeysIterator.remove();

            ByteBuffer requestBuffer = responseContext.get(selectionKey);
            if (requestBuffer == null) {
                requestBuffer = ByteBuffer.allocate(Settings.count);
                responseContext.put(selectionKey, requestBuffer);
            }

            if (!selectionKey.isValid()) {
                selectionKey.cancel();
                continue;
            }

            if (selectionKey.isAcceptable()) {
                System.out.print("accept event fired");
                SocketChannel socketChannel = serverChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                System.out.println("accept event over");
                System.out.println("------------------");
            }
            /*else if (selectionKey.isConnectable()) {
                System.out.print("connect event fired");
                //SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                System.out.println("connect event over");
                System.out.println("------------------");
            } */
            if (selectionKey.isReadable()) {
                System.out.println("read event fired");
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                requestBuffer.clear();

                if (readBookmarks.get(selectionKey) != null) {
                    continue;
                }

                int size = socketChannel.read(requestBuffer);
                if (size > 0) {
                    byte[] bytes = new byte[size];
                    requestBuffer.flip();
                    requestBuffer.get(bytes);
                    readBookmarks.put(selectionKey, size);
                    System.out.println("read content : " + Hex.encodeHexString(bytes));
                }

                System.out.println("read event over ");
                System.out.println("------------------");
            } else if (selectionKey.isWritable()) {
                System.out.println("write event fired");
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                Integer size = readBookmarks.get(selectionKey);
                if (size == null) {
                    System.out.println("no request data");
                    continue;
                }

                Integer old = writeBookmarks.get(selectionKey);

                //still no data sent out
                if (old == null) {
                    requestBuffer.clear();

                    for (int i = 0; i < Settings.count; i++) {
                        requestBuffer.put((byte) (i % 2 == 0 ? 0 : 1));
                    }
                    System.out.println("begin to write to channel" + ", time : " + new Date() + ", timeMills : " + System.currentTimeMillis());
                    requestBuffer.flip();
                    int mark = socketChannel.write(requestBuffer);

                    String s = "end to write to channel, write bytes length : %s, time : %s, timeMills : %s, requestBuffer remaining legnth : %s";
                    System.out.println(String.format(s, mark, new Date(), System.currentTimeMillis(), requestBuffer.remaining()));
                    System.out.println("------------------");
                    writeBookmarks.put(selectionKey, mark);
                    if (mark == Settings.count) {
                        writeBookmarks.remove(selectionKey);
                        System.out.println("channel close, totalWriteLength : " + mark);
                        writeBookmarks.remove(selectionKey);
                        responseContext.remove(selectionKey);
                        socketChannel.close();
                    }

                } else {
                    int mark = socketChannel.write(requestBuffer);
                    int totalWriteBytesLength = mark + old;
                    writeBookmarks.put(selectionKey, totalWriteBytesLength);

                    String s = "continue to write to channel, write bytes length : %s, time : %s, timeMills : %s, requestBuffer remaining legnth : %s";
                    System.out.println(String.format(s, totalWriteBytesLength, new Date(), System.currentTimeMillis(), requestBuffer.remaining()));

                    if (totalWriteBytesLength == Settings.count) {
                        writeBookmarks.remove(selectionKey);
                        responseContext.remove(selectionKey);
                        System.out.println("channel close, totalWriteLength : " + totalWriteBytesLength);
                        socketChannel.close();
                    }
                }
            }
        }
    }
}
