package lock.timer;

import java.util.concurrent.locks.LockSupport;

public class App {
    public static void main(String[] args) throws Exception {
        final Thread main = Thread.currentThread();
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                }

                Object blocker = LockSupport.getBlocker(main);
                System.out.println(blocker);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (App.class){
                    try {
                        System.out.println("begin to sleep 5s");
                        Thread.sleep(5000);
                        System.out.println("end to sleep 5s");
                    }catch (Exception e) {

                    }

                }
            }
        }.start();

        Thread.sleep(1000);

        synchronized (App.class){
            System.out.println("main gain lock");
            //App.class.wait();
            System.out.println(App.class);
            App.class.wait(5*1000);
        }
    }
}
