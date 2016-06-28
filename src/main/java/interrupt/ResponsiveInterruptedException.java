package interrupt;

import java.util.Arrays;
import java.util.List;

public class ResponsiveInterruptedException {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                List<String> arr = Arrays.asList("1", "2", "3", "4", "5");
                for (int i = 0; i < 5; i++) {
                    // Pause for 4 seconds
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        // We've been interrupted: no more messages.
                        System.out.println("interrupted by outside");
                        return;
                    }
                    // Print a message
                    System.out.println(arr.get(i));
                }
            }
        });

        t1.start();

        Thread.sleep(2000);

        t1.interrupt();



    }
}
