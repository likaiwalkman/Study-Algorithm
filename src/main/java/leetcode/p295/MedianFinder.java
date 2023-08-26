package leetcode.p295;

import java.util.Deque;
import java.util.LinkedList;

class MedianFinder {

    private boolean deleteBeforeAdd = true;
    private Deque<Integer> deque = new LinkedList<>();

    public MedianFinder() {}

    public void addNum(int num) {
        if (deleteBeforeAdd) {
            if (!deque.isEmpty()){
                deque.pollFirst();
            }
        }
        deque.offerLast(num);
        deleteBeforeAdd = !deleteBeforeAdd;
    }

    public double findMedian() {
        if (deleteBeforeAdd) {
            Integer first = deque.pollFirst();
            Integer secondFirst = deque.pollFirst();
            deque.offerFirst(secondFirst);
            deque.offerFirst(first);
            return (first + secondFirst) / 2.0;

        }else {
            return deque.peekFirst();
        }
    }
}
