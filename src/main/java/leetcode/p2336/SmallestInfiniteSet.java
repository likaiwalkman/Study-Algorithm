package leetcode.p2336;

import java.util.*;

public class SmallestInfiniteSet {
    private PriorityQueue<Integer> heap;

    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            heap.offer(i);
        }
    }

    public int popSmallest() {
        return heap.poll();
    }

    public void addBack(int num) {
        if (!heap.contains(num)) {
            heap.offer(num);
        }
    }
}
