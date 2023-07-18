package lock.juc;

public class App {

    public static void main(String[] args) {
        int n = Runtime.getRuntime().availableProcessors();
        System.out.println(n);
    }

}
