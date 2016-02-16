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
                public void run() {
                    try {
                        InputStream ins = socket.getInputStream();
                        int i = -1;
                        while ((i=ins.read())!=-1){
                            System.out.println(i);
                            if (197 == i) {//
                                Thread.sleep(40*1000);
                            }

                        }
                        System.out.println("haha");
                        String fileName = "/Users/victor/git/Study-Algorithm/src/main/java/tcp/Client.java";
                        System.out.println("hehe");
                        File file = new File(fileName);
                        System.out.println(file.getName());
                        InputStream fins = new FileInputStream(file);
                        int pos = -1;
                        while((pos=fins.read())!=-1){
                            System.out.println(pos);
                            socket.getOutputStream().write(pos);
                        }
                        socket.getOutputStream().close();
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

        try {
            Thread.sleep(1000*60*60*24);//sleep one day
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
