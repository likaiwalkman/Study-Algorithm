package asyn.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * Created by victor on 16/3/1.
 */
public class AjaxServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket       socket = null;
        while(true){
            socket = server.accept();
            System.out.println("New connection created");
            final  Socket s = socket;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.getOutputStream().write("{\"name\":\"victor\",".getBytes());
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        s.getOutputStream().write("{\"gender\":\"male\"}".getBytes());
                        s.shutdownOutput();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
