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
            Map<SelectionKey, ByteBuffer> context = new HashMap<SelectionKey, ByteBuffer>();
            Map<SelectionKey, Integer> bookmark = new HashMap<SelectionKey, Integer>();

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

                    ByteBuffer requestBuffer = context.get(selectionKey);
                    if (requestBuffer == null) {
                        requestBuffer = ByteBuffer.allocate(Settings.count);
                        context.put(selectionKey, requestBuffer);
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
                        System.out.println("channel: " + socketChannel);
                        System.out.println("------------------");
                    }
                    if (selectionKey.isConnectable()) {
                        System.out.print("connect event fired");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        System.out.println("channel: " + socketChannel);
                        System.out.println("------------------");
                    }
                    if (selectionKey.isReadable()) {
                        System.out.print("read event fired");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        requestBuffer.clear();

                        int size = socketChannel.read(requestBuffer);
                        if (size > 0) {
                            byte[] bytes = new byte[size];
                            requestBuffer.flip();
                            requestBuffer.get(bytes);
                            System.out.print("read content : " + Hex.encodeHexString(bytes));
                        }

                        System.out.println("read channel over ");
                        System.out.println("------------------");
                    }
                    if (selectionKey.isWritable()) {
                        System.out.println("write event fired");
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                        if (bookmark.get(selectionKey) == null) {
                            requestBuffer.clear();
                            requestBuffer.compact();

                            byte[] writes = new byte[Settings.count];
                            boolean flip = false;
                            for (int i = 0; i < writes.length; i++) {
                                flip = !flip;
                                if (flip) {
                                    writes[i] = 0;
                                } else {
                                    writes[i] = 1;
                                }
                            }

                            requestBuffer.flip();
                            requestBuffer.put(writes);
                            System.out.println("begin to write to channel" + ", time : " + new Date() + ", timeMills : " + System.currentTimeMillis());
                            requestBuffer.flip();
                            int mark = socketChannel.write(requestBuffer);

                            int remaining = requestBuffer.remaining();
                            boolean b = mark + remaining == Settings.count;
                            System.out.println("equaling ? " + b);

                            System.out.println("end to write to channel" + ", time : " + new Date() + ", timeMills : " + System.currentTimeMillis());
                            System.out.println("------------------");
                            if (remaining == 0) {
                                bookmark.remove(selectionKey);
                                socketChannel.close();
                            } else {
                                bookmark.put(selectionKey, mark);
                            }

                        } else {
                            int mark = socketChannel.write(requestBuffer);
                            int remaining = requestBuffer.remaining();
                            if (remaining == 0) {
                                bookmark.remove(selectionKey);
                                socketChannel.close();
                            } else {
                                Integer old = bookmark.get(selectionKey);
                                bookmark.put(selectionKey, mark+old);
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
