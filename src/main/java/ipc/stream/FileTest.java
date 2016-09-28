package ipc.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fprinter = new PrintStream(new FileOutputStream("/Users/victor/Desktop/ipc/f.txt"));

        Scanner scanner = new Scanner(System.in);
        String  line;
        while ((line=scanner.nextLine())!=null){
            fprinter.println(line);
            fprinter.flush();
        }
    }
}
