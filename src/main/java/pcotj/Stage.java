package pcotj;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Stage {

    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch l = new CountDownLatch(1);
//        l.countDown();
//        l.countDown();
//        System.out.println(l.getCount()); // --> 0

        long startTime = System.currentTimeMillis();
        ExecutorService threadPool = null;

        try {
            threadPool = Executors.newFixedThreadPool(Constants.THREAD_SIZE);
            CountDownLatch countDownLatch = new CountDownLatch(Constants.SIZE);

            for (int i = 0; i < Constants.THREAD_SIZE; i++) {
                threadPool.execute(new Worker(countDownLatch));
            }

            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            long endTime = System.currentTimeMillis();

            int cpuCoreNum = Runtime.getRuntime().availableProcessors();
            System.out.println("Number of CPU cores :" + cpuCoreNum);
            System.out.println("Work time (millisecond) :" + Constants.WORK_TIME_MILLISECOND);
            System.out.println("Block time (millisecond) :" + Constants.BLOCK_TIME_MILLISECOND);

            Double blockCoefficient = (Constants.BLOCK_TIME_MILLISECOND * 1d) / (Constants.WORK_TIME_MILLISECOND + Constants.BLOCK_TIME_MILLISECOND);
            System.out.println("Block coefficient :" + blockCoefficient);

            int optimalThreadNum = new Double(cpuCoreNum / (1 - blockCoefficient)).intValue();
            System.out.println("Optimal thread number in theory:" + optimalThreadNum);

            System.out.println("Number of Task :" + Constants.SIZE);
            System.out.println("Number of Thread :" + Constants.THREAD_SIZE);
            System.out.println("Cost Time:" + (endTime - startTime));
            try {
                threadPool.shutdownNow();
            } catch (Exception e) {
            }
        }
    }
}