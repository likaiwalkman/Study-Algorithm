package asyn.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;

/**
 * Created by victor on 16/3/1.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket       socket = null;
        while(true){
            socket = server.accept();
            System.out.println("new connection is created");
            final  Socket s = socket;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(s);
                    try {
                        s.connect(s.getRemoteSocketAddress());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SocketChannel channel = s.getChannel();
                    try {
                        channel.finishConnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
