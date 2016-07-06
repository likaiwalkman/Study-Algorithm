package processComm;

import java.io.*;
import java.net.URL;

public class Outer {
    public static void main(String[] args) throws IOException {

        ProcessBuilder builder = new ProcessBuilder();
        builder.command("java -cp /Users/victor/git/Study-Algorithm/target/classes processComm.Inner");
        URL resource = Outer.class.getResource("/");
        System.out.println(resource.getPath());
        builder.directory(new File(resource.getPath()));
        Process p = builder.start();

        //Process p = Runtime.getRuntime().exec("java Inner");
        InputStream ins = p.getInputStream();
        OutputStream ous = p.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(ous));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));

        BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        while ((input = stdin.readLine()) != null){
            bufferedWriter.write(input);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            String s = null;
            while ((s = bufferedReader.readLine()) == null){

            }
            stdout.write(s);
        }
    }
}
