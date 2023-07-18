package lock.juc.tp;

public class CoreTask implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(40*1000);
        }catch (Exception e){}
    }
}
