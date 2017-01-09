package concurrent.threadPool.app;

import concurrent.threadPool.copy.Executors;

import java.util.concurrent.ExecutorService;

public class Launcher {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Over");
            }
        });
        executorService.shutdown();
    }
}
