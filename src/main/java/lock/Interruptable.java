package lock;

/***
 * Excerpted from "Seven Concurrency Models in Seven Weeks",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/pb7con for more book information.
 ***/

import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

public class Interruptable {

    public static void main(String[] args) throws InterruptedException, IOException {

//        InputStream ins = new FileInputStream(new File("/Users/victor/Desktop/hanatour-crawler2.rar"));
//
//        OutputStream ous = new FileOutputStream(new File("/Users/victor/Desktop/hanatour-crawler.rar"));
//
//        int bit;
//
//        while ((bit = ins.read()) != -1){
//            ous.write((-(byte)(bit)));
//        }

        final ReentrantLock l1 = new ReentrantLock();
        final ReentrantLock l2 = new ReentrantLock();

        Thread t1 = new Thread() {
            public void run() {
                super.run();;
                try {
                    l1.lockInterruptibly();
                    Thread.sleep(1000);
                    l2.lockInterruptibly();
                } catch (InterruptedException e) { System.out.println("t1 interrupted"); }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    l2.lockInterruptibly();
                    Thread.sleep(1000);
                    l1.lockInterruptibly();
                } catch (InterruptedException e) { System.out.println("t2 interrupted"); }
            }
        };

        t1.start();
        t2.start();
        Thread.sleep(2000);
        t1.interrupt();
        t2.interrupt();
        t1.join();
        t2.join();
    }
}

