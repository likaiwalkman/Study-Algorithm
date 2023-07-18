package lock.sync;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        new Producer(list).start();
        new Consumer(list).start();
    }
}
