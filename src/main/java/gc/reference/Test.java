package gc.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class Test {

    /**
     * phantom reference 的 get 方法永远返回 null
     */
    @org.junit.Test
    public void phantomReferenceAlwaysNull() throws InterruptedException {
        new Integer("2");

        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        outer(referenceQueue);
        System.gc();
        Thread.sleep(1000);
        Reference polledObj = null;
        while ((polledObj = referenceQueue.poll()) == null){
            System.gc();
        }
        System.out.println(polledObj);

        System.out.println(referenceQueue);



    }
    static void outer(ReferenceQueue<Object> referenceQueue){
        String name = new String("lilei");
        test(referenceQueue, name);
    }
    static void test(ReferenceQueue<Object> referenceQueue, String name){
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(name, referenceQueue);
        assert phantomReference.get() == null;


    }
}
