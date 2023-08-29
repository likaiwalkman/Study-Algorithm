package leetcode.p502;

import java.util.*;

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> optionalMaxProfitHeap = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        PriorityQueue<int[]> notMatchedMinCapitalHeap = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        for (int i = 0; i < capital.length; i++) {
            int[] item = {capital[i], profits[i]};
            if (w >= item[0]) {
                optionalMaxProfitHeap.offer(item);
            }else {
                notMatchedMinCapitalHeap.offer(item);
            }
        }

        while (k > 0 && !optionalMaxProfitHeap.isEmpty()){
            int[] maxProfitRoot = optionalMaxProfitHeap.poll();
            k--;
            w += maxProfitRoot[1];
            while (!notMatchedMinCapitalHeap.isEmpty() && notMatchedMinCapitalHeap.peek()[0] <= w){
                optionalMaxProfitHeap.offer(notMatchedMinCapitalHeap.poll());
            }
        }
        return w;
    }
}
