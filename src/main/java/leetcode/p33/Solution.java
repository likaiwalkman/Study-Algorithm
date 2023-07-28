package leetcode.p33;

public class Solution {
    public int search(int[] nums, int target) {
        return nonSortedSearch(nums, 0, nums.length-1, target);
    }

    public int nonSortedSearch(int[] nums, int start, int end, int target){
        if (start == end){
            if (nums[start] != target) {
                return -1;
            }else {
                return start;
            }
        }

        if (nums[start] < nums[end]) {
            return sortedSearch(nums, start, end, target);
        }else {
            int mid = (start + end) / 2;
            if (nums[mid] >= nums[start]) {
                //前部分有序
                if (target >= nums[start] && target <= nums[mid]) {
                    return sortedSearch(nums, start, mid, target);
                }else {
                    return nonSortedSearch(nums, mid+1, end, target);
                }
            }else {
                //后部分有序
                if (target >= nums[mid+1] && target <= nums[end]) {
                    return sortedSearch(nums, mid+1, end, target);
                }else {
                    return nonSortedSearch(nums, start, mid, target);
                }
            }
        }

    }

    public int sortedSearch(int[] nums, int start, int end, int target){
        if (start == end){
            if (nums[start] != target) {
                return -1;
            }else {
                return start;
            }
        }

        if (nums[start] > target || nums[end] < target) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }else if (nums[mid] >= target){
            return sortedSearch(nums, start, mid, target);
        }else {
            return sortedSearch(nums, mid+1, end, target);
        }
    }
}
