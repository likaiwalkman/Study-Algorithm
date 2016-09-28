package ipc.stream;

import java.io.*;
import java.util.Scanner;

public class Sub {
    public static void main(String[] args) throws IOException, InterruptedException {


        FileOutputStream fos = new FileOutputStream("/Users/victor/Desktop/ipc/c.txt");
        PrintStream printer = new PrintStream(fos);

        System.out.println("haha");
        System.out.println("hehe");
        System.out.println("你好");

        String line;
        Scanner scanner = new Scanner(System.in, "UTF-8");
        while ((line = scanner.nextLine()) != null) {
            //process input line, then write back result line
            System.out.println(line+"(processed)");
            System.out.flush();
        }
        System.out.println("over");
        //fileOutputStream.close();
    }
}
