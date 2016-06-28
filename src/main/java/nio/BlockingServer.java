package nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by victor on 16/3/13.
 */
public class BlockingServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = null;
            while ((socket = serverSocket.accept()) !=null) {
                System.out.println("accept");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
