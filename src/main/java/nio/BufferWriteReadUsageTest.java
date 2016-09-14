package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;

public class BufferWriteReadUsageTest {
    public static void main(String[] args) throws IOException {
        int capacity = 128;
        ByteBuffer buffer = ByteBuffer.allocate(capacity);
        
        /*System.out.println(buffer.remaining());
        buffer.put((byte)1);
        System.out.println(buffer.remaining());
        buffer.put((byte)1);
        System.out.println(buffer.remaining());

        buffer.flip();
        System.out.println(buffer.remaining());
        buffer.get();
        System.out.println(buffer.remaining());

        buffer.clear();

        System.out.println(buffer.remaining());*/

        for (int i = 0; i < capacity; i++) {
            buffer.put((byte)(i % 2 == 0 ? 0 : 1));
        }

        System.out.println(buffer.remaining());
        buffer.flip();
        System.out.println(buffer.remaining());

        buffer.compact();

        buffer.position();
    }
}
