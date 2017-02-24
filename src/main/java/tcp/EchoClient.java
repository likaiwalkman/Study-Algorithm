package tcp;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoClient {
    public static void main(String[] args) throws SocketException, InterruptedException {
        Socket client = new Socket();
        try {
            client.connect(new InetSocketAddress("localhost", 8080));
            client.setSoTimeout(5*1000);
            OutputStream ous = client.getOutputStream();
            ous.write("a".getBytes());
            InputStream inputStream = client.getInputStream();
            int b;
            boolean flag = true;
            while ( flag && (b=inputStream.read()) != -1){
                System.out.print((char)b);
                flag = false;
            }
            Thread.sleep(5*60*1000);
            ous.write("c".getBytes());
            //System.out.println();
            Thread.sleep(120000);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
