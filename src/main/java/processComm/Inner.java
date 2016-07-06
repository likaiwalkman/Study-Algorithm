package processComm;

import java.io.*;

public class Inner {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        while ((input = bufferedReader.readLine()) != null){
            bufferedWriter.write(input);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            //bufferedWriter.newLine();
            //bufferedWriter.flush();
        }
    }
}
