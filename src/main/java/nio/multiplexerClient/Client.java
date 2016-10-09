package nio.multiplexerClient;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

public class Client {
    private static byte[] bytes;

    static {
        //Get baidu log gif request
        String base64edReq = "R0VUIGh0dHA6Ly9ob21lLmJhaWR1LmNvbS9yZXNvdXJjZS9yL2hvbWUvaW1nL2xvZ28teXkuZ2lmIEhUVFAvMS4xDQpIb3N0OiBob21lLmJhaWR1LmNvbQ0KQ29ubmVjdGlvbjoga2VlcC1hbGl2ZQ0KQ2FjaGUtQ29udHJvbDogbWF4LWFnZT0wDQpVcGdyYWRlLUluc2VjdXJlLVJlcXVlc3RzOiAxDQpVc2VyLUFnZW50OiBNb3ppbGxhLzUuMCAoV2luZG93cyBOVCA2LjE7IFdPVzY0KSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvNTIuMC4yNzQzLjExNiBTYWZhcmkvNTM3LjM2DQpBY2NlcHQ6IHRleHQvaHRtbCxhcHBsaWNhdGlvbi94aHRtbCt4bWwsYXBwbGljYXRpb24veG1sO3E9MC45LGltYWdlL3dlYnAsKi8qO3E9MC44DQpBY2NlcHQtRW5jb2Rpbmc6IGd6aXAsIGRlZmxhdGUsIHNkY2gNCkFjY2VwdC1MYW5ndWFnZTogemgtQ04semg7cT0wLjgNCkNvb2tpZTogQkFJRFVJRD01QTk3QjlGQURCMkU2MUMwMTg0NTRBQzRBRkRFREJCMjpGRz0xOyBCSURVUFNJRD01QTk3QjlGQURCMkU2MUMwMTg0NTRBQzRBRkRFREJCMjsgUFNUTT0xNDcwOTg0MjI1OyBCRFVTUz1OMFZuZGthalExU0hscE1DMUZlRW93YmpCblppMHRMWE16U21wSWVFdGlNRmhMVmpaRGRubDRNMHhDWjFwWlFWRkJRVUZCSkNRQUFBQUFBQUFBQUFFQUFBQlROR3dIYkdscllXbDNZV3hyYldGdUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQU10NTNsZkxlZDVYWm07IHBndl9wdmk9NTA2MTIyODU0NDsgcGd2X3NpPXM2MzA5ODA4MTI4OyBNQ0lUWT0tJTNBOyBCRFNGUkNWSUQ9c1NJc0plQ0N4RzM2WmZKUlUwTFZITE5mY29tenZMeFJFRGN0M0o7IEhfQkRDTENLSURfU0Y9dGJrRG9JTGF0RHZhZTVySS10VEpxNF9ITWxvV0tDNjJhS0RzME1vMS1oY3FFSUw0alQzSzBuOFgwNHJqLU0zWjNKUnlMQ2JMYlBKQk1VYlNqNFF6eVVrckt4YzQteG8teUkzZS1wM0QtcDVuaE1KbTI1N0pETVAwcXQ2ZXE0b3k1MjNpb241dlFwbi1meHR1ajYwaGpUakJlcEpmLUtDSHRKLVgzYjdFSEpPX2JVRndNbmJrYmZKQkR4cjJCSlFOUU5ybjVKUU5XcUwyRFBLd01KQzV5cEQ3eWFqSzJNckdiMnJuV1J2djA0b2pWbG5hcUo3cFFUOHJibEFPSzVPaWI0ajlhLUtLYWIzdk9JSk5YcE8xNVJLcmVHTE9KVHRqdFJ1SlYtNTgyUjdfS1JPMU10Yk9xNElPcXhieTI2blIwbUplYUo1bkpEb0VFbjVoeVVuQ2JUSi15dDZsSlBSdGFDajNvSlA1UXBQLUhxVHh5LTZ2UTVMcnk0dXEyaGI3M0lRZEtsME1McGNsYmIweHlub0QzNHUweU1uTUJNUGo1bU9uYVBRS0xJRktoS3Q5RFQ4NWo1UFc1cHRYYVBvMGJLNjBXbjdhLWJuRUtST3ZoajRCM0l1eXl4b210ampRUTZRZ294ajRRNjZ0c2J2S0tsYmFiZkxaM3hGZkxVa3FLQ09PMjRiSjB4b3RLcWpFanBvYmhxS3dRdHRqUVA1dWZJa2phLTV0LXhKNE9SN1R5VTQyYmY0N3loajJRVEllSmJDdF9JdHlmLTVfako3a3E0YlNNdHRmcXg2YmV0SnlhUjNlYmhUYldKNVRFUG5qRFRqQWJ4SXczSDNyTGZ2ckJEYzJXYjZMYnFSV1ZsNWUtbjg1eTZJU0t4LV90NktqSlJyUDsgQkRSQ1ZGUltwRmszUlpUazhhMF09bWszU0xWTjRIS207IEhtX2x2dF9iOWE3NzgyMGIyZmExN2Q3MjIzYjUwYTAxYWIxYWE3YT0xNDc1OTc3MjM2OyBIbV9scHZ0X2I5YTc3ODIwYjJmYTE3ZDcyMjNiNTBhMDFhYjFhYTdhPTE0NzU5NzcyMzY7IEhfUFNfUFNTSUQ9MTQ2NV8yMDk3Ml8xNzk0NF8yMTExNF8xNzAwMV8yMTE5Ml8yMTE2MF8yMDkyOQ0KSWYtTm9uZS1NYXRjaDogImVhMDFlMS02NTItNDhkZGVjZWUxYzAwMCINCklmLU1vZGlmaWVkLVNpbmNlOiBTdW4sIDE1IEF1ZyAyMDEwIDE2OjAwOjAwIEdNVA0KDQo=";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            bytes = decoder.decodeBuffer(base64edReq);
            //System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        try (SocketChannel channel = SocketChannel.open()) {
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_CONNECT);

            channel.connect(new InetSocketAddress("home.baidu.com", 80));

            Map<SelectableChannel, Map<String, Object>> context = new HashMap<SelectableChannel, Map<String, Object>>();

            while (true) {
                int select = selector.select();
                if (select == 0) {
                    continue;
                }

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isConnectable()) {
                        if (channel.finishConnect()) {
                            channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        }
                        //SelectableChannel ch = key.channel();
                    }
                    if (key.isWritable()) {
                        Map<String, Object> item = context.get(channel) != null ? context.get(channel) : new HashMap<String, Object>();
                        if (item.size() == 0) {

                            /*item = new HashMap<String, Object>();*/
                            context.put(channel, item);
                            assert item != null;
                            item.put("count", bytes.length);
                            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
                            for (byte b : bytes) {
                                byteBuffer.put(b);
                            }
                            item.put("byteBuffer", byteBuffer.flip());

                            RandomAccessFile raf = new RandomAccessFile("D:/0.gif", "rw");
                            FileChannel fc = raf.getChannel();
                            item.put("fileChannel", fc);
                        }
                        Integer count = (Integer) item.get("count");
                        if (count != 0) {
                            int writes = channel.write((ByteBuffer) item.get("byteBuffer"));
                            count -= writes;
                            item.put("count", count);
                        }

                    }
                    if (key.isReadable()) {
                        Map<String, Object> item = context.get(channel);
                        if (item != null) {
                            if (item.get("count") == 0) {
                                ByteBuffer allocateBuffer = ByteBuffer.allocate(2048);
                                channel.read(allocateBuffer);
                                allocateBuffer.flip();
                                FileChannel fileChannel = (FileChannel) item.get("fileChannel");
                                while (allocateBuffer.hasRemaining()) {
                                    fileChannel.write(allocateBuffer);
                                    /*byte b = allocateBuffer.get();
                                    System.out.print((char)b);*/
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
