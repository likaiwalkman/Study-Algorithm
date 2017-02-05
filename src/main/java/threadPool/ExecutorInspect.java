package threadPool;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorInspect {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe;
        final Thread t = Thread.currentThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    LockSupport.unpark(t);
                } catch (Exception e){
                }
            }
        });//.start();
        System.out.println("hh");
        final ReentrantLock lock = new ReentrantLock(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    lock.lock();
                }catch (Exception e){

                }
            }
        }).start();
        lock.lock();
        lock.lock();
        lock.unlock();
        //LockSupport.park();
    }
}
