package nio.line;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LineEchoServer {
    static final int PORT = Integer.parseInt(System.getProperty("port", "8009"));

    public static void main(String[] args) throws IOException {


        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));

        Map<SelectableChannel, Map<String, Object>> context = new HashMap<SelectableChannel, Map<String, Object>>();

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Set<SelectionKey> updatedSelectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> updatedSelectedKeysIterator = updatedSelectedKeys.iterator();
            while (updatedSelectedKeysIterator.hasNext()) {
                SelectionKey currentSelectedKey = updatedSelectedKeysIterator.next();
                updatedSelectedKeysIterator.remove();

                SelectableChannel currentClientChannel = currentSelectedKey.channel();

                if (currentSelectedKey.isAcceptable()) {
                    currentClientChannel = serverSocketChannel.accept();
                    currentClientChannel.configureBlocking(false);
                    currentClientChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                } else if (currentSelectedKey.isReadable()) {
                    Map<String, Object> item = context.get(currentClientChannel);

                    if (item == null) {
                        item = new HashMap<String, Object>();
                        context.put(currentClientChannel, item);
                    }

                    ByteBuffer byteBuffer = (ByteBuffer) item.get("DATA");
                    if (byteBuffer == null) {
                        byteBuffer = ByteBuffer.allocate(1024);
                        item.put("DATA", byteBuffer);
                    }

                    if (!"WRITABLE".equals(item.get("mode"))) {

                        ((SocketChannel) currentClientChannel).read(byteBuffer);
                        byte end = byteBuffer.get(byteBuffer.position() - 1);
                        char dot = '.';
                        if (dot == end) {
                            item.put("mode", "WRITABLE");
                            item.put("count", byteBuffer.position());
                        }
                    }

                } else {
                    Map<String, Object> item = context.get(currentClientChannel);
                    if (item != null) {
                        if ("WRITABLE".equals(item.get("mode"))) {
                            ByteBuffer byteBuffer = (ByteBuffer) item.get("DATA");
                            Boolean fliped = (Boolean) item.get("fliped");
                            if (fliped == null) {
                                byteBuffer.flip();
                                fliped = true;
                                item.put("fliped", fliped);
                            }
                            int write = ((SocketChannel) currentClientChannel).write(byteBuffer);
                            Integer count = (Integer) item.get("count");
                            count -= write;
                            if (count != 0) {
                                item.put("count", count);
                            } else {
                                currentClientChannel.close();
                            }

                        }
                    }
                }

            }
        }

    }
}
