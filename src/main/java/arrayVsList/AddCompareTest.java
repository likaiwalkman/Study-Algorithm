package arrayVsList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AddCompareTest {
    public static void main(String[] args) {
        final List<Integer> linkedList = new LinkedList();
        final List<Integer> arrayList = new ArrayList(16);
        int addTimes = 1000000;

        Long start = System.currentTimeMillis();
        for (int i = 0; i < addTimes; i++) {
            linkedList.add(i);
        }
        Long cost = System.currentTimeMillis() - start;
        System.out.println("linkedlist cost: "+cost);

        start = System.currentTimeMillis();
        for (int i = 0; i < addTimes; i++) {
            arrayList.add(i);
        }
        cost = System.currentTimeMillis() - start;
        System.out.println("arraylist cost: "+cost);
    }
}
