package blockingIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by victor on 16/3/12.
 */
public class PackTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(9090);
        System.out.println(server.getInetAddress().getHostAddress());
        Socket client = null;
        if ((client = server.accept())!=null) {
            client.getOutputStream().write(1);
            Thread.sleep(5000);
            client.getOutputStream().write(0);

        }
        Path p = Paths.get(".");
        System.out.println(p.getFileName());
    }
}
