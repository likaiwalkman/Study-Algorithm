package nio;

import org.apache.commons.codec.binary.Hex;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

/**
 * nio test
 * Created by victor on 16/3/13.
 */
public class Server implements Runnable {

    public static void main(String[] args) {
        new Thread(new Server()).start();
    }

    public void run() {
        try {
            Map<SelectionKey, ByteBuffer> responseContext = new HashMap<SelectionKey, ByteBuffer>();
            Map<SelectionKey, Integer> bookmark = new HashMap<SelectionKey, Integer>();
            Map<SelectionKey, Integer> requestContext = new HashMap<SelectionKey, Integer>();

            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress("localhost", 9090));
            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
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
                    } else if (selectionKey.isConnectable()) {
                        System.out.print("connect event fired");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        System.out.println("connect event over");
                        System.out.println("------------------");
                    } else if (selectionKey.isReadable()) {
                        System.out.println("read event fired");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        requestBuffer.clear();

                        int size = socketChannel.read(requestBuffer);
                        if (size > 0) {
                            byte[] bytes = new byte[size];
                            requestBuffer.flip();
                            requestBuffer.get(bytes);
                            requestContext.put(selectionKey, size);
                            System.out.println("read content : " + Hex.encodeHexString(bytes));
                        }

                        System.out.println("read event over ");
                        System.out.println("------------------");
                    } else if (selectionKey.isWritable()) {
                        System.out.println("write event fired");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                        Integer size = requestContext.get(selectionKey);
                        if (size == null) {
                            System.out.println("no request data");
                            continue;
                        }

                        Integer old = bookmark.get(selectionKey);

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
                            bookmark.put(selectionKey, mark);
                            if (mark == Settings.count) {
                                bookmark.remove(selectionKey);
                                System.out.println("channel close, totalWriteLength : " + mark);
                                bookmark.remove(selectionKey);
                                responseContext.remove(selectionKey);
                                socketChannel.close();
                            }

                        } else {
                            int mark = socketChannel.write(requestBuffer);
                            int totalWriteBytesLength = mark + old;
                            bookmark.put(selectionKey, totalWriteBytesLength);

                            String s = "continue to write to channel, write bytes length : %s, time : %s, timeMills : %s, requestBuffer remaining legnth : %s";
                            System.out.println(String.format(s, totalWriteBytesLength, new Date(), System.currentTimeMillis(), requestBuffer.remaining()));

                            if (totalWriteBytesLength == Settings.count) {
                                bookmark.remove(selectionKey);
                                responseContext.remove(selectionKey);
                                System.out.println("channel close, totalWriteLength : " + totalWriteBytesLength);
                                socketChannel.close();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
