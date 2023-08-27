package leetcode.p295;

import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1-o2);

    public MedianFinder() {}

    public void addNum(int num) {
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        }else {
            minHeap.offer(num);
        }
        if (minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        if (maxHeap.size()-minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 1 ){
            return maxHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}
