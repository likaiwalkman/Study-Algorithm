package nb;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * m
 * Created by victor on 16/3/12.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket();
        s.connect(new InetSocketAddress(InetAddress.getLocalHost(), 9090));
        s.shutdownInput();
        s.shutdownOutput();
//        boolean b = 1 & 0;
    }
}
