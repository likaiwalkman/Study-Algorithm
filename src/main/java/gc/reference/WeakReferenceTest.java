package gc.reference;


public class WeakReferenceTest {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(123);


        putThreadLocal();
        putThreadLocal();
        putThreadLocal();

        for (int j = 0; j < 80; j++) {
            usedToTriggerGc();
        }

        threadLocal.remove();

        Thread thread = Thread.currentThread();
        System.out.println();

        System.out.println(thread);
    }

    public static void usedToTriggerGc(){
        int[] ints = new int[1024 * 1024 * 70];
    }

    public static void putThreadLocal(){
        ThreadLocal<Integer> test = new ThreadLocal<>();
        test.set(999);
    }

}


class ModifyVariableThread extends Thread {
    private ThreadLocal<int[]> threadLocal;
    private int id;
    public ModifyVariableThread(ThreadLocal<int[]> threadLocal, int id){
        this.threadLocal = threadLocal;
        this.id = id;
    }
    @Override
    public void run() {
        threadLocal.get()[0]= 1;
    }
}