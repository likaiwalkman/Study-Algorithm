package ipc.stream;

import java.io.*;
import java.util.Scanner;

public class ProcessStarter {
    public static void main(String[] args) throws IOException {
        System.out.println("\n\nParent Started..");
        System.out.println("\nStarting Child Process..");

        //Build Child Process from command line arguments
        ProcessBuilder pb = new ProcessBuilder("pwd");
        //Start Child process
        Process child = pb.start();

        //Get stream from child process (IPC)
        InputStream instream = child.getInputStream();
        Scanner     in       = new Scanner(instream, "GB2312");
        //Read the child process output
        System.out.println("\nReading from Child Process..");

        FileOutputStream stream = new FileOutputStream(new File("D:\\test.txt"));
        PrintWriter      p      = new PrintWriter(stream);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(s);
            //p.println(s);
        }
        //p.println("Writing this sentence into thefile!");
        //p.close();
        stream.close();
        try {
            child.waitFor(); //parent blocks and waits for child to finish
        } catch (InterruptedException e) {}
        System.out.println("\nDone.. ");
        child.destroy();
    }
}
