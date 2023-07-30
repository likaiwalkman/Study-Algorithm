package rateLimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class RateLimiterTest {
    public static void main(String[] args) throws Exception {
        RateLimiter rateLimiter = RateLimiter.create(100.0D);
        int num = 100;


        for (int k = 0; k < 10; k++) {
            int sleepTime = k;
            int count = 0;
            for (int i = 0; i < num; i++) {
                boolean b = rateLimiter.tryAcquire();
                TimeUnit.MILLISECONDS.sleep(sleepTime);
                if(!b){
                    //System.out.println("not success");
                    count++;
                }
            }
            System.out.println("each sleep time:"+sleepTime +", not get lock count:"+count);
        }

        TimeUnit.SECONDS.sleep(1);
        int count = 0;
        for (int i = 0; i < num; i++) {
            boolean b = rateLimiter.tryAcquire();
            TimeUnit.MILLISECONDS.sleep(0);
            if(!b){
                //System.out.println("not success");
                count++;
            }
        }
        System.out.println("after 1s silence, each sleep time:"+0 +", not get lock count:"+count);

    }
}
