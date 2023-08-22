package leetcode.p153;

public class Solution {

    public int findMin(int[] nums) {
        int n = nums.length;
        return findMin(nums, 0, nums.length-1);
    }

    int findMin(int[] nums, int start, int end){
        if (start == end) {
            return nums[start];
        }
        if(nums[start] < nums[end]){
            return nums[start];
        }
        int mid = (start+end) / 2;
        if (nums[mid] > nums[end]){
            return findMin(nums, mid+1, end);
        }else {
            return findMin(nums, start, mid);
        }
    }
}
