package arrayVsList;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class BenchMarkTest {
    public static void main(String[] args) throws InterruptedException {

        final List linkedList = new LinkedList();
        final List arrayList = new ArrayList(16);

        CountDownLatch latches = new CountDownLatch(3);
        final Semaphore semaphore = new Semaphore(2);
        final Semaphore start = new Semaphore(2);
        CyclicBarrier barrier = new CyclicBarrier(3);
        semaphore.acquire(1);
        semaphore.acquire(1);

        start.acquire(2);

        final int count = 10000;

        long t = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            linkedList.add(i);
            linkedList.add("a");
        }
        System.out.println("list:"+(System.currentTimeMillis()-t));

        t = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            arrayList.add(i);
            arrayList.add("a");
        }
        System.out.println("array:"+(System.currentTimeMillis()-t));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    start.acquire(1);
                    long t = System.currentTimeMillis();
                    for (int i = 0; i < count; i++) {
                        linkedList.add(i);
                        linkedList.add("a");
                    }
                    System.out.println("list:"+(System.currentTimeMillis()-t));
                } catch (Exception e){

                } finally {
                    semaphore.release(1);
                    start.release(1);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    start.acquire(1);
                    long t = System.currentTimeMillis();
                    for (int i = 0; i < count; i++) {
                        arrayList.add(i);
                        arrayList.add("a");
                    }
                    System.out.println("array:"+(System.currentTimeMillis()-t));
                } catch (Exception e){

                } finally {
                    semaphore.release(1);
                    start.release(1);
                }
            }
        }).start();

        start.release(2);
    }
}

class Element{
    private int a = 'a';
    private String b = new String("b");
}
