package leetcode.p80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int newLen = 0;
        int gap = 0;
        int write = 0;
        for (int i = 0; i < nums.length;) {
            int j = i;
            while (j+1 < nums.length && nums[j+1] == nums[i]){
                j++;
            }

            for (int k = i; k <=j && k <= i+1 ; k++) {
                nums[write]=nums[i];
                write++;
            }

            if (j-i>1) {
                gap += j-i-1;
                newLen += 2;
            }else {
                newLen += j-i+1;
            }

            i=j+1;
        }
        return newLen;
    }
}
