package nio;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class NonBlockingClient implements Runnable {

    HashMap<SocketChannel, ByteBuffer> responseContext = new HashMap<SocketChannel, ByteBuffer>();
    HashMap<SocketChannel, ByteBuffer> requestContext = new HashMap<SocketChannel, ByteBuffer>();
    HashMap<SocketChannel, Integer> bookmark = new HashMap<SocketChannel, Integer>();
    HashMap<SocketChannel, Integer> responseCounter = new HashMap<SocketChannel, Integer>();

    public static void main(String[] args) throws IOException {
        new Thread(new NonBlockingClient()).start();
    }

    public void run() {
        try{
            int concurrencyCount = 1;

            Selector selector = Selector.open();

            for (int i = 0; i < concurrencyCount; i++) {
                SocketChannel sc = SocketChannel.open();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_CONNECT);

                InetSocketAddress serverSocketAddress = new InetSocketAddress(Settings.SERVER_HOST, Settings.SERVER_PORT);
                sc.connect(serverSocketAddress);
            }

            while (true){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                if (selectionKeys.size() == 0) {
                    continue;
                }
                Iterator<SelectionKey> itr = selectionKeys.iterator();
                while (itr.hasNext()) {
                    SelectionKey sk = itr.next();
                    SocketChannel sc = (SocketChannel) sk.channel();
                    itr.remove();
                    if (sk.isConnectable()) {
                        if (sc.finishConnect()) {
                            sc.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
                        }
                    }

                    if (sk.isWritable()){
                        Integer bm = bookmark.get(sc);
                        if (bm == null) {
                            ByteBuffer requestBuffer = requestContext.get(sc);//ByteBuffer.allocate(1);
                            if (requestBuffer == null) {
                                requestBuffer = new BASE64Decoder().decodeBufferToByteBuffer(Base64.HTTP_REQUEST);
                                requestBuffer.flip();
                                requestContext.put(sc, requestBuffer);
                            }

                            //requestBuffer.put((byte)1);
                            int write = sc.write(requestBuffer);
                            if (write == 1) {
                                bookmark.put(sc, write);
                            }
                        }
                    }
                    if (sk.isReadable()){
                        if (bookmark.get(sc) == null) {
                            continue;
                        }
                        ByteBuffer response = responseContext.get(sc);
                        if (response == null) {
                            response = ByteBuffer.allocate(Settings.count);
                        }
                        sc.read(response);
                        if (response.position() == response.capacity()) {
                            //read over
                            sc.close();
                        }
                    }
                }
            }
        } catch (Exception e){

        }
    }
}
