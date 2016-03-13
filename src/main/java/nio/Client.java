package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by victor on 16/3/13.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            System.out.println(socket);
            socket.connect(new InetSocketAddress("localhost", 9090));
            socket.shutdownInput();
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
