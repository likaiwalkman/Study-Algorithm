package leetcode.p55;

public class Solution {
    public boolean canJump(int[] nums) {

        int zeroMaxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroMaxIndex = i;
            }

            int k = zeroMaxIndex;

            if (zeroMaxIndex == nums.length-1) {
                return true;
            }
            boolean  zeroMaxIndexSureToEnter = zeroMaxIndex > -1;
            int distance = 1;
            while (k-distance >= 0){
                if (nums[k-distance] > distance) {
                    zeroMaxIndexSureToEnter = false;
                    break;
                }
                distance++;
            }
            zeroMaxIndex = -1;

            if (zeroMaxIndexSureToEnter){
                return false;
            }
        }
        return true;
    }
}
