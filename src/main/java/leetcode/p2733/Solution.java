package leetcode.p2733;

public class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length <= 2) {
            return -1;
        }
        int[] arr = new int[]{nums[0], nums[1], nums[2]};
        if (arr[0] > arr[1]) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        if (arr[1] > arr[2]){
            int temp = arr[1];
            arr[1] = arr[2];
            arr[2] = temp;
        }
        if (arr[0] > arr[1]) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }

        return arr[1];
    }
}
