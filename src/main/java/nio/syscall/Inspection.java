package nio.syscall;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;



public class Inspection {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 256);
        try{
            int      count    = 1;
            Selector selector = Selector.open();
            for (int i = 0; i < count; i++) {
                SocketChannel sc = SocketChannel.open();
                System.out.print("");
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_CONNECT);

                InetSocketAddress serverSocketAddress = new InetSocketAddress("localhost", 8080);
                boolean           connect             = sc.connect(serverSocketAddress);
                System.out.println("connected:"+connect);
            }

            int sum = 0;

            while (true){
                selector.select();

                Set<SelectionKey> keys = selector.selectedKeys();
                if (keys.size() == 0) {
                    continue;
                }
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    iterator.remove();

                    if (selectionKey.isConnectable()) {
                        if (true || sc.finishConnect()) {
                            if ((++sum) == 3) {
                                //System.exit(0);
                            }
                            sc.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
                        }
                    }

                    if (selectionKey.isWritable()){
                        try {
                            ByteBuffer buffer = ByteBuffer.allocate(1);
                            byte       b      = (byte) (System.currentTimeMillis() % 2 == 0 ? 1 : 0);
                            buffer.put(b);
                            buffer.flip();
                            int write = sc.write(buffer);
                            if (write > 0) {
                                System.out.println("write : "+b);
                                System.out.println("------");
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                    if (selectionKey.isReadable()){
//                        ByteBuffer buffer = ByteBuffer.allocate(1);
//                        int reads = sc.read(buffer);
//                        if (reads > 0) {
//                            buffer.flip();
//                            byte b = buffer.get();
//                            System.out.println("read : " +b);
//                            System.out.println("------");
//                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

