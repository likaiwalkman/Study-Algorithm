package forkJoin.versus;

import java.net.Socket;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class App {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 1000).toArray();

        //Executors.newCachedThreadPool()
        Socket socket;
        //socket.getInputStream().
        //SocketInputStreamRMHooks

        Instant start = Instant.now();
        //Calculator calculator = new ForLoopCal();
        //Calculator calculator = new ExecutorServiceCalculator();
        Calculator calculator = new ForkJoinCalculator();
        long result = calculator.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result);
    }
}
