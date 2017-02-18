package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {

                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            InputStream ins = socket.getInputStream();
                            int         i   = 0;
                            boolean     f   = true;
                            while (f && (i = ins.read()) != -1) {
                                System.out.print((char) i);
                                if (i == 'o') {
                                    f = false;
                                }
                            }
                            Thread.sleep(5);
                            socket.getOutputStream().write("Hi".getBytes());
                            socket.shutdownOutput();
                            //socket.getInputStream().close();


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
        }

       /* try {
            Thread.sleep(1000 * 60 * 60 * 24);//sleep one day
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}
