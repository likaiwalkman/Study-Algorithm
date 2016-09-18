package nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;

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

    @Test
    public void testPut(){
        int capacity = 128;
        ByteBuffer buffer = ByteBuffer.allocate(capacity);
        System.out.printf("position:%s, limit:%s, capacity:%s \n",buffer.position(), buffer.limit(), buffer.capacity());
        buffer.put((byte)1);
        System.out.printf("position:%s, limit:%s, capacity:%s \n",buffer.position(), buffer.limit(), buffer.capacity());
    }

    @Test
    public void testGet(){
        int capacity = 128;
        ByteBuffer buffer = ByteBuffer.allocate(capacity);
        buffer.put((byte)1);
        System.out.printf("position:%s, limit:%s, capacity:%s \n",buffer.position(), buffer.limit(), buffer.capacity());
        buffer.flip();
        System.out.printf("position:%s, limit:%s, capacity:%s \n",buffer.position(), buffer.limit(), buffer.capacity());
        buffer.get();
        System.out.printf("position:%s, limit:%s, capacity:%s \n",buffer.position(), buffer.limit(), buffer.capacity());
    }

    @Test
    public void testCompact(){
        int capacity = 128;
        ByteBuffer buffer = ByteBuffer.allocate(capacity);
        buffer.put((byte)1);
        buffer.put((byte)1);
        System.out.printf("position:%s, limit:%s, capacity:%s \n",buffer.position(), buffer.limit(), buffer.capacity());
        buffer.flip();
        System.out.printf("position:%s, limit:%s, capacity:%s \n",buffer.position(), buffer.limit(), buffer.capacity());
        buffer.get();
        System.out.printf("position:%s, limit:%s, capacity:%s \n",buffer.position(), buffer.limit(), buffer.capacity());
        buffer.compact();
        System.out.printf("position:%s, limit:%s, capacity:%s \n",buffer.position(), buffer.limit(), buffer.capacity());
    }
}
