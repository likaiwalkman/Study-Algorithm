package forkJoin.versus;
import java.util.concurrent.*;
public class ForkJoinCalculator implements Calculator {

    private ForkJoinPool pool;

    //执行任务RecursiveTask：有返回值  RecursiveAction：无返回值
    private static class SumTask extends RecursiveTask<Long> {
        private long[] numbers;
        private int from;
        private int to;
        private int sleepMills = 1000;

        public SumTask(long[] numbers, int from, int to, int sleepMills) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
            this.sleepMills = sleepMills;
        }

        //此方法为ForkJoin的核心方法：对任务进行拆分  拆分的好坏决定了效率的高低
        @Override
        protected Long compute() {
            Thread thread = Thread.currentThread();
            // 当需要计算的数字个数小于6时，直接采用for loop方式计算结果
            if (to - from < 2) {
                long total = 0;
                for (int i = from; i <= to; i++) {
                    total += numbers[i];
                }
                printLine(String.format("nums[%-2d]+nums[%-2d] = %-6d tid:%-2d",from, to, total, thread.getId()));
                return total;
            } else { // 否则，把任务一分为二，递归拆分(注意此处有递归)到底拆分成多少分 需要根据具体情况而定
                int middle = (from + to) / 2;
                SumTask taskLeft = new SumTask(numbers, from, middle, sleepMills+1000);
                SumTask taskRight = new SumTask(numbers, middle + 1, to, sleepMills+1000);
                String format = String.format(" => break into pieces %02d-%02d, %-2d-%-2d, tid: %-2d", from, middle, middle, to, thread.getId());
                printLine(format);
                taskLeft.fork();
                String forkAfter = String.format(" => oneForkAfter into pieces %02d-%02d, %-2d-%-2d, tid: %-2d", from, middle, middle, to, thread.getId());
                printLine(forkAfter);
                taskRight.fork();
                printLine(String.format("watch point 1 tid:%3d", Thread.currentThread().getId()));
                long leftPartResult = taskLeft.join();
                long rightPartResult = taskRight.join();
                printLine("watch point 2");
                if (sleepMills == 5000){
                    System.out.println("watch");
                }
                staticSleep(500);
                long sum = leftPartResult + rightPartResult;
                printLine(String.format("nums[%3d]+nums[%-2d] indirect eval to %-6d tid:%-2d",from, to, sum, thread.getId()));
                //printLine("[" + from  + "]:"+ numbers[from] + "-["+ to +"]:"+ numbers[to]+" indirect eval:"+ sum +", tid:"+thread.getId());
                return sum;
            }
        }
    }

    public ForkJoinCalculator() {
        pool = new ForkJoinPool(3, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, false);
    }

    @Override
    public long sumUp(long[] numbers) {
        Long result = pool.invoke(new SumTask(numbers, 0, numbers.length - 1, 0));
        pool.shutdown();
        return result;
    }

    static void staticSleep(int mills){
        try {
            if (control_watcher_sleep){
                Thread.sleep(mills);
            }
        }catch (Exception e){}
    }

    static boolean print_detail_log = true;
    static boolean control_watcher_sleep = true;
    public static void printLine(String s){
        if (print_detail_log){
            String tname = Thread.currentThread().getName();
            System.out.println(s+" tname:"+tname);
        }
    }
}
