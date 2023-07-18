package lock.interrupt;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

public class InterruptTest {
    public static void main(String[] args) throws Exception {
        final Thread main = Thread.currentThread();
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("begin to sleep " + new Date());
                    Thread.sleep(5000);
                    System.out.println("begin to wake " + new Date());
                    main.interrupt();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        for (int i = 0; i < 3; i++) {
            System.out.println("isInterrupted before status:"+ Thread.currentThread().isInterrupted());
        }
        System.out.println("-----------------");
        LockSupport.park(Object.class);
        for (int i = 0; i < 3; i++) {
            System.out.println("isInterrupted after status:"+ Thread.currentThread().isInterrupted());
        }
        System.out.println("-----------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("interrupted after status:"+ Thread.interrupted());
        }
    }
}
