package pcotj;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {


    private CountDownLatch countDownLatch;

    public Worker(CountDownLatch countDownLatch) {


        this.countDownLatch = countDownLatch;
    }

    public void run() {


        try {
            long cnt = countDownLatch.getCount();
            //System.out.println("cnt:"+cnt);
            while (cnt > 0) {

                //do work
                TestUtil.doWorkByTime(Constants.WORK_TIME_MILLISECOND);

                //do block operation
                TestUtil.doBlockOperation(Constants.BLOCK_TIME_MILLISECOND);

                countDownLatch.countDown();
                cnt = countDownLatch.getCount();
                //System.out.println("cnt after:"+cnt);
            }
        } catch (InterruptedException e) {
        }

    }
}