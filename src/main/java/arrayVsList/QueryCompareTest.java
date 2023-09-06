package arrayVsList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QueryCompareTest {
    public static void main(String[] args) {
        final List<Integer> linkedList = new LinkedList();
        final List<Integer> arrayList = new ArrayList(16);
        int listSize = 10000;
        int queryTimes = 100000;
        for (int i = 0; i < listSize; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }
        int[] ints = new int[queryTimes];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(listSize);
        }
        Long start = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            linkedList.get(ints[i]);
        }
        Long cost = System.currentTimeMillis() - start;
        System.out.println("linkedlist cost: "+cost);

        start = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            arrayList.get(ints[i]);
        }
        cost = System.currentTimeMillis() - start;
        System.out.println("arraylist cost: "+cost);
    }
}
