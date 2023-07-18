package lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 {
    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock(true);

        for (int i = 1; i <= 3; i++) {
            lock.lockInterruptibly();
        }

        for(int i=1;i<=3;i++){
            try {
                System.out.println("haha");
            } finally {
                lock.unlock();
            }
        }

        Thread.currentThread().interrupt();
    }
}
