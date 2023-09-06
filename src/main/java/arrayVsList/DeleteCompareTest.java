package arrayVsList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DeleteCompareTest {
    public static void main(String[] args) {
        final List<Integer> linkedList = new LinkedList();
        final List<Integer> arrayList = new ArrayList(16);
        int addTimes = 1000000;

        for (int i = 0; i < addTimes; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        int deleteTimes = 1000;

        Random random = new Random();
        int[] ints = new int[deleteTimes];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(deleteTimes);
        }

        Long start = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            linkedList.remove(ints[i]);
        }
        Long cost = System.currentTimeMillis() - start;
        System.out.println("linkedlist cost: "+cost);

        start = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            arrayList.remove(ints[i]);
        }
        cost = System.currentTimeMillis() - start;
        System.out.println("arraylist cost: "+cost);
    }
}
