package leetcode.p703;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> heap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;

        if (nums != null){
            for (int num : nums) {
                if (heap.size() < k) {
                    heap.offer(num);
                }else {
                    if (heap.peek() < num) {
                        heap.poll();
                        heap.offer(num);
                    }
                }
            }
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
            return heap.peek();
        }else {
            if (heap.peek() < val) {
                heap.poll();
                heap.offer(val);
                return heap.peek();
            }else {
                return heap.peek();
            }
        }
    }
}
