package leetcode.p287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int s = 0;
        int f = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i != nums[i]){
                s=f=i;
                break;
            }
        }
        while (true){
            s = nums[s];
            f = nums[nums[f]];

            if (s == f) {
                break;
            }
        }

        f=0;
        while (true){
            s = nums[s];
            f = nums[f];

            if (s == f) {
                break;
            }
        }

        return s;

    }
}
