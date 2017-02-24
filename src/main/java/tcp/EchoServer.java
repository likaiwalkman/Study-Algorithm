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
                                f = false;
                            }
                            Thread.sleep(5);
                            socket.getOutputStream().write("b".getBytes());
                            socket.getOutputStream().flush();

                            //1、invoke socket's close method to close tcp connection
                            //socket.close();

                            //2、invoke socket's shutdownOutput method to close tcp connection
                            //socket.shutdownOutput();

                            //3、invoking socket's shutdownInput method will NOT close tcp connection
                            socket.shutdownInput();

                            //socket.getInputStream().close();
                            Thread.sleep(5*60*1000);


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
