package leetcode.p215;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minRootHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minRootHeap.size() < k) {
                minRootHeap.offer(num);
            }else {
                Integer oldTop = minRootHeap.peek();
                if (num > oldTop) {
                    minRootHeap.poll();
                    minRootHeap.offer(num);
                }
            }
        }
        return minRootHeap.peek();
    }
}
