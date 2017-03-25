package pcotj.divideAndConquer.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentPrimeFinder extends AbstractPrimeFinder {
    private final int poolSize;
    private final int numberOfParts;

    public ConcurrentPrimeFinder(final int thePoolSize,
                                 final int theNumberOfParts) {
        poolSize = thePoolSize;
        numberOfParts = theNumberOfParts;
    }

    public int countPrimes(final int number) {
        int count = 0;
        try {
            final List<Callable<Integer>> partitions =
                    new ArrayList<Callable<Integer>>();
            final int chunksPerPartition = number / numberOfParts;
            for (int i = 0; i < numberOfParts; i++) {
                final int lower = (i * chunksPerPartition) + 1;
                final int upper =
                        (i == numberOfParts - 1) ? number
                                : lower + chunksPerPartition - 1;
                partitions.add(new Callable<Integer>() {
                    public Integer call() {
                        return countPrimesInRange(lower, upper);
                    }
                });
            }
            final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
            ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService(executorPool);
            for (Callable<Integer> partition : partitions) {
                completionService.submit(partition);
            }
            //executorPool.awaitTermination(100, TimeUnit.SECONDS);
            executorPool.shutdown();

            //final List<Future<Integer>> resultFromParts = executorPool.invokeAll(partitions, 10000, TimeUnit.SECONDS);
            //executorPool.shutdown();
            for (int i = 0; i < partitions.size(); i++) {
                Future<Integer> result = completionService.take();
                count += result.get();
            }
            //for (final Future<Integer> result : resultFromParts)
              //  count += result.get();
        } catch (Exception ex) { throw new RuntimeException(ex); }
        return count;
    }

    public static void main(final String[] args) {
        int num = 1000000000;
        int poolSize = 8;
        int numberOfParts = 256;

        new ConcurrentPrimeFinder(poolSize,numberOfParts).timeAndCompute(num);
        // 2.003s 8thread 16parts 10^7
        // 42.48s 8thread 16parts 10^8
        // 44.48s 8thread 32parts 10^8
        // 42.17s 8thread 64parts 10^8
        // 43.96s 8thread 128parts 10^8
        // 43.64s 8thread 256parts 10^8
    }
}
