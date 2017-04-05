package gc.reference;


public class Finalizer {
    public static void main(String[] args) throws InterruptedException {
        test();
        System.gc();
        test();
        System.gc();
        Thread.sleep(10000);
    }
    static void test(){
        Instance ins = new Instance();
    }
    static class Instance {
        Instance(){
            System.out.println("instance init");
        }
        @Override
        protected void finalize() throws Throwable {
            System.out.println("fn is called");
            super.finalize();
            throw new IllegalArgumentException("nothing err in fact");
        }
    }
}
