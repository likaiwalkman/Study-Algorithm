package gc.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

public class PhantomNotifierTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        list.add("lilei");

        ReferenceQueue<List<String>> referenceQueue = new ReferenceQueue<List<String>>();
        PhantomReference<List<String>> phantomReference = new PhantomReference<List<String>>(list, referenceQueue);
        int count = 0;
        while (true) {
            Reference<? extends List<String>> poll = referenceQueue.poll();
            if ( poll == null) {
                System.out.println("not collected");
            } else {
                System.out.println("collected"+poll);
            }
            if (count == 3) {
                list = null;
            } else if (count == 10){
                break;
            }
            count++;
        }
    }
}
