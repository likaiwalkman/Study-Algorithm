package leetcode.lruCache;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * No remarks
 * Created by victor on 16/3/9.
 */
public class LRUCache {

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        //LinkedList<PrintNumTask> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            queue.add(new PrintNumTask(i+1));
        }
        BlockingQueue<Runnable> q = queue;
        ExecutorService exeService = Executors.newFixedThreadPool(5);//new ThreadPoolExecutor(11,12,10,TimeUnit.SECONDS,q);//Executors.newFixedThreadPool(6);
//        exeService.
        for (int i = 0; i < 5; i++) {
            //Runnable r = queue.poll();
            //System.out.println(r);//
            //exeService.submit(r);
        }
//        exeService.shutdownNow();
    }
}

class PrintNumTask implements Runnable {

    private int num;

    public PrintNumTask() {
    }

    public PrintNumTask(int num) {
        this.num = num;
    }

    public void printNum() {

//        for (int i = 0; i < 1000000; i++) {
//            int a = 1;
//            int b =a - 1;
//        }
        System.out.println(num);
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        printNum();
    }
}
