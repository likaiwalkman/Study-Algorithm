package ipc.stream;

import ipc.stream.worker.Producer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process sub = Runtime.getRuntime().exec("java ipc.stream.Sub");
        OutputStream subOutputStream = sub.getOutputStream();

        Producer producer = new Producer(System.in, subOutputStream);
        new Thread(producer).start();


        InputStream subInputStream = sub.getInputStream();
        Scanner in = new Scanner(subInputStream, "UTF-8");
        String l;
        while ((l = in.nextLine()) != null) {
            System.out.println(l);
        }

    }
}
