package lock.juc.tp;

import java.util.concurrent.*;

public class ThreadPoolTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    static int ctlOf(int rs, int wc) { return rs | wc; }
    static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    static int workerCountOf(int c)  { return c & CAPACITY; }

    public static void main(String[] args) throws Throwable {


        final int RUNNING    = -1 << COUNT_BITS;
        final int SHUTDOWN   =  0 << COUNT_BITS;
        final int STOP       =  1 << COUNT_BITS;
        final int TIDYING    =  2 << COUNT_BITS;
        final int TERMINATED =  3 << COUNT_BITS;

        int i0 = RUNNING;
        int i1 = RUNNING + 1;
        int i2 = RUNNING + 2;

        int j0 = workerCountOf(i0);
        int j1 = workerCountOf(i1);
        int j2 = workerCountOf(i2);


        int coreSize = 2;
        int maxSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                coreSize,
                maxSize,
                keepAliveTime,
                unit,
                workQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());


        threadPoolExecutor.execute(new CoreTask());
        threadPoolExecutor.execute(new CoreTask());
        threadPoolExecutor.execute(new CoreTask());
        threadPoolExecutor.execute(new CoreTask());
        Thread.sleep(5*1000);
        threadPoolExecutor.execute(new MaxTask());

        //threadPoolExecutor.getCompletedTaskCount();

        threadPoolExecutor.shutdown();
        threadPoolExecutor.shutdownNow();
    }
}
