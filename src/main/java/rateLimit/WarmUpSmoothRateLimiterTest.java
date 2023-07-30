package rateLimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class WarmUpSmoothRateLimiterTest {
    public static void test(RateLimiter rateLimiter, int coldRatio) throws Exception{

        int num = 100;
        for (int k = 1; k <= 10; k++) {
            int sleepTime = k;
            int count = 0;
            for (int i = 0; i < num; i++) {
                boolean b = rateLimiter.tryAcquire();
                TimeUnit.MILLISECONDS.sleep(sleepTime * coldRatio);
                if(!b){
                    count++;
                }
            }
            TimeUnit.MILLISECONDS.sleep(sleepTime * coldRatio+20);
            System.out.println("each sleep time:"+sleepTime +", not get lock count:"+count);
        }
    }
    public static void main(String[] args) throws Exception {
        int warmUpTime = 15;
        RateLimiter rateLimiter = RateLimiter.create(100.0, warmUpTime, TimeUnit.SECONDS);
        System.out.println("---------");
        test(rateLimiter, 3);
        System.out.println("---------");
        TimeUnit.SECONDS.sleep(warmUpTime+2);
        int count = 0;
        for (int i = 0; i < 100; i++) {
            boolean b = rateLimiter.tryAcquire();
            TimeUnit.MILLISECONDS.sleep(10);
            if(!b){
                count++;
            }
        }
        System.out.println("after "+warmUpTime+"s silence, each sleep time:"+0 +", not get lock count:"+count);

        System.out.println("---------");
        TimeUnit.SECONDS.sleep(2);
        test(rateLimiter, 1);

    }
}
