package leetcode.p162;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]){
                return 0;
            }else {
                return 1;
            }
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length-2] < nums[nums.length-1]){
            return nums.length-1;
        }

        return findPeakElement(nums, 0, nums.length-1);
    }
    //asc                        desc
    //4 5 ...mid-1...mid...mid+1...5 4
    public int findPeakElement(int[] nums, int from, int to){
        int mid = (from + to) / 2;
//        asc  desc  => mid
//        asc  asc   => after
//        desc desc  => before
//        desc asc   => before
        if (nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
            return mid;
        } else if (nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]){
            return findPeakElement(nums, mid, to);
        }else {
            return findPeakElement(nums, from, mid);
        }
    }

}
