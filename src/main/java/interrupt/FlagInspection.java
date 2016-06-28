package interrupt;

import java.util.Arrays;
import java.util.List;

public class FlagInspection {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                List<String> arr = Arrays.asList("1", "2", "3", "4", "5");
                for (int i = 0; i < 5; i++) {
                    //Thread.interrupted(): will clear interrupted flag
                    //Thread.currentThread().isInterrupted(): will not clear interrupted flag

                    // inspect for interrupted flag
                    if (Thread.interrupted()) {
                        // We've been interrupted: no more crunching.
                        System.out.println("interrupted by outside");
                        //return;
                    }
                    // Print a message
                    System.out.println(arr.get(i));
                }
            }
        });

        t1.start();

        //Thread.sleep(0, 2);

        t1.interrupt();
    }
}
