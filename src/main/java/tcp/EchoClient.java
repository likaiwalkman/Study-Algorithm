package tcp;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoClient {
    public static void main(String[] args) throws SocketException {
        Socket client = new Socket();
        try {
            client.connect(new InetSocketAddress("localhost", 8080));
            client.setSoTimeout(50);
            OutputStream ous = client.getOutputStream();
            ous.write("Hello".getBytes());
            InputStream inputStream = client.getInputStream();
            int b;
            while ((b=inputStream.read()) != -1){
                System.out.print((char)b);
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
