package mergeSort;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.*;

class ReadTask implements Callable<String>{
    private BufferedReader reader;

    public ReadTask(BufferedReader reader){
        this.reader = reader;
    }

    @Override
    public String call() throws Exception {
        String s;
        while ((s = reader.readLine()) != null){
            return s;
        }
        return null;
    }
}

public class SortBigFile {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String c1 = "1\r\n4\r\n5\r\n6\r\n8\r\n9\r\n";
        String c2 = "2\r\n3\r\n7\r\n";
        final BufferedReader reader1 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(c1.getBytes())));
        final BufferedReader reader2 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(c2.getBytes())));

        ExecutorService executor = Executors.newScheduledThreadPool(2);

        Future<String> future1, future2;
        future1 = executor.submit(new ReadTask(reader1));
        future2 = executor.submit(new ReadTask(reader2));

        String s1 = null, s2 = null;
        while ( (s1 = future1.get()) != null | (s2 = future2.get()) != null){
            if (s1 != null && s2 != null) {
                if (Integer.valueOf(s1) > Integer.valueOf(s2)) {
                    System.out.println(s2);
                    System.out.println(s1);
                } else {
                    System.out.println(s1);
                    System.out.println(s2);
                }
                future1 = executor.submit(new ReadTask(reader1));
                future2 = executor.submit(new ReadTask(reader2));
            } else if (s1 != null){
                System.out.println(s1);
                future1 = executor.submit(new ReadTask(reader1));
            } else {
                System.out.println(s2);
                future2 = executor.submit(new ReadTask(reader2));
            }
        }
        executor.shutdown();
    }
}
