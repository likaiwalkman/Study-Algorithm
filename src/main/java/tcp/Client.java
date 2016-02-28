package tcp;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by victor on 16/2/4.
 */
public class Client {
    public static void main(String[] args) {
        Socket client = new Socket();
        try {
            client.connect(new InetSocketAddress("localhost", 8080));
            OutputStream ous = client.getOutputStream();
            ous.write(97);
            if (1==0) Thread.sleep(20*1000);
            for (int i = 0; i < 10; i++) {
                ous.write(i);
            }
//            ous.close();
            client.shutdownOutput();

            OutputStream fous = new FileOutputStream(new File("haha"));
            int pos= -1;
            while((pos=client.getInputStream().read())!=-1){
                fous.write(pos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
