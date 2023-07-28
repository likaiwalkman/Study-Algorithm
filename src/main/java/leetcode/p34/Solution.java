package leetcode.p34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int i = sortedSearch(nums, 0, nums.length - 1, target, 0);
        if (i == -1) {
            return new int[]{-1,-1};
        }else {
            int j = sortedSearch(nums, 0, nums.length - 1, target, 1);
            return new int[]{i, j};
        }
    }

    public int sortedSearch(int[] nums, int start, int end, int target, int mode){
        if (start == end){
            if (nums[start] == target) {
                return start;
            }
        }
        if (nums[start] > target || target > nums[end]){
            return -1;
        }

        int mid = (start + end) / 2;

        int [] option1 = new int[]{start, mid};
        int [] option2 = new int[]{mid+1, end};
        int[][] options = new int[][]{option1, option2};
        int[] option = options[mode];
        int[] otherOption = options[1-mode];

        if (target >= nums[option[0]] && target <= nums[option[1]]){
            return sortedSearch(nums, option[0], option[1], target, mode);
        }else {
            return sortedSearch(nums, otherOption[0], otherOption[1], target, mode);
        }
    }
}
