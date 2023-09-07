package leetcode.p334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (length < 3){
            return false;
        }
        int[] arr1 = new int[length];
        arr1[0]=1;
        int min = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > min) {
                arr1[i] = 2;
            }else {
                min = nums[i];
                arr1[i] = 1;
            }
        }
        Integer firstIndex = null;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 2) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == null) {
            return false;
        }
        min = nums[firstIndex];
        for (int i = firstIndex + 1; i < arr1.length; i++) {
            if (arr1[i] != 2) {
                continue;
            }
            if (nums[i] > min) {
                return true;
            }else {
                min = nums[i];
            }
        }
        return false;
    }
}
