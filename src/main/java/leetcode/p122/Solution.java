package leetcode.p122;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public int maxProfit(int[] prices) {
        int[] ints = new int[prices.length - 1];
        for (int i = 0; i < prices.length-1; i++) {
            ints[i] = prices[i+1] - prices[i];
        }
        int total = 0;
        for (int i : ints) {
            if (i > 0) {
                total += i;
            }
        }
        return total;
    }

//    public int maxProfit(int[] prices) {
//        List<Integer> partialResult = new ArrayList<>();
//
//        int cursor = -1;
//        AtomicInteger atomicInteger = new AtomicInteger();
//        recurive(atomicInteger, partialResult, prices, cursor);
//        return atomicInteger.get();
//    }

    public void recurive(AtomicInteger atomicInteger, List<Integer> partialResult, int[] prices, int cursor) {

        if (cursor >= prices.length - 1) {
            refreshBestResult(partialResult, prices, atomicInteger);
            return;
        }


        for (int i = 0; i < prices.length; i++) {

            if (partialResult.size() > 0) {
                int lastPartialResultIndex = partialResult.get(partialResult.size() - 1);
                if (lastPartialResultIndex >= i) {
                    continue;
                }
            }

            boolean partialResultFilled = false;
            if (partialResult.size() % 2 == 0) {
                partialResult.add(i);
                partialResultFilled = true;
            } else {
                if (prices[i] > prices[partialResult.get(partialResult.size() - 1)]) {
                    partialResult.add(i);
                    partialResultFilled = true;
                } else {
                    for (int k = partialResult.get(partialResult.size()-1)+1; k < prices.length; k++) {
                        if (prices[partialResult.get(partialResult.size() - 1)] < prices[k]) {
                            i = k;
                            partialResult.add(i);
                            partialResultFilled = true;
                            break;
                        }
                    }
                    if (!partialResultFilled) {
                        i = prices.length-1;
                    }
                }
            }
            recurive(atomicInteger, partialResult, prices, i);
            if (partialResultFilled) {
                partialResult.remove(partialResult.size() - 1);
            }
            System.out.println();
        }

    }

    public void refreshBestResult(List<Integer> partialResult, int[] prices, AtomicInteger atomicInteger){
        if (partialResult.size() > 0) {
            int total = 0;
            Iterator<Integer> iterator = partialResult.iterator();
            while (iterator.hasNext()) {
                int i = iterator.next();
                if (iterator.hasNext()){
                    int j = iterator.next();
                    total += prices[j] - prices[i];
                }
            }

            if (total > atomicInteger.get()) {
                atomicInteger.set(total);
            }
        }
    }


}
