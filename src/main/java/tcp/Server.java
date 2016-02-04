package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by victor on 16/2/4.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            final Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream ins = socket.getInputStream();
                        int i = -1;
                        while ((i=ins.read())!=-1){
                            System.out.println(i);
                            if (97 == i) {
                                Thread.sleep(20*1000);
                            }

                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000*60*60*24);//sleep one day
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
