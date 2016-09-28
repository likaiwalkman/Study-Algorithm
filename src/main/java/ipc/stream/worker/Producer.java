package ipc.stream.worker;

import java.io.*;
import java.util.Scanner;

public class Producer implements Runnable {

    private InputStream mainStdIn;

    private OutputStream transOutputStream;

    public Producer(InputStream mainStdIn, OutputStream transOutputStream){
        this.mainStdIn = mainStdIn;
        this.transOutputStream = transOutputStream;
    }

    @Override
    public void run() {
        System.out.println("run...");
        PrintStream printer = new PrintStream(transOutputStream);

        PrintStream fprinter = null;
        try {
            fprinter = new PrintStream(new FileOutputStream("/Users/victor/Desktop/ipc/f.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(mainStdIn);
        String line;
        System.out.println("listener thread start up...");
        while ((line=scanner.nextLine())!=null){
            printer.println(line);
            printer.flush();
        }
    }
}
