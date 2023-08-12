package leetcode.p215;

import java.util.PriorityQueue;
import java.util.Random;

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

    public int findKthLargest2(int[] nums, int k) {
        Random random = new Random();

        int fromIndex = 0;
        int toIndex = nums.length-1;

        int pivotIndex = divideArray(nums, fromIndex, toIndex, random);
        while (nums.length-pivotIndex != k){
            if (nums.length-pivotIndex > k) {
                fromIndex = pivotIndex+1;
                pivotIndex = divideArray(nums, fromIndex, toIndex, random);
            }else {
                toIndex = pivotIndex;
                pivotIndex = divideArray(nums, fromIndex, toIndex, random);
            }
        }
        return nums[pivotIndex];
    }

    private int divideArray(int[] nums, int fromIndex, int toIndex, Random random) {
        if (fromIndex == toIndex){
            return fromIndex;
        }
        int pivotIndex = random.nextInt(toIndex-fromIndex) + fromIndex;
        if(pivotIndex != fromIndex){
            swap(nums, fromIndex, pivotIndex);
            pivotIndex = fromIndex;
        }

        int i = fromIndex;
        int j = toIndex;

        int pivotValue = nums[i];

        while (i != j){
            if (i < pivotIndex) {
                if (nums[i] < pivotValue){
                    i++;
                }else {
                    nums[pivotIndex] = nums[i];
                    j--;
                    pivotIndex = i;
                }
            }else {
                if (pivotValue <= nums[j]){
                    j--;
                }else {
                    nums[pivotIndex] = nums[j];
                    i++;
                    pivotIndex = j;
                }
            }
        }
        nums[pivotIndex] = pivotValue;
        return pivotIndex;
    }

    private void swap(int[] nums, int i, int j){
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
