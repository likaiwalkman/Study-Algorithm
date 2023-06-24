package leetcode.p75;

public class Solution {
    public void sortColors(int[] nums) {
        int i = -1;
        int j1 = -1;
        int j2 = -1;
        int k = nums.length;

        int index = 0;
        int sortedCnt = 0;
        while (sortedCnt < nums.length){
            if (nums[index] == 0) {
                if (j1 >= 0) {
                    int old = nums[j1];
                    nums[j1] = nums[index];
                    nums[index] = old;
                    j1++;
                    j2++;
                }

                i++;
                index++;
            }else if (nums[index] == 2){
                int old = nums[--k];
                nums[k] = nums[index];
                nums[index] = old;

                if (j2 >= 0 && j2 > k){
                    int old2 = nums[j2];
                    nums[j2] = nums[index];
                    nums[index] = old2;
                    j1--;
                    j2--;
                    k--;
                }

            }else {
                if (j1 < 0) {
                    j1 = j2 = index;
                }else {
                    j2++;
                }
                index++;;
            }
            sortedCnt = i+1 + nums.length-k + (j1 < 0 ? 0: j2-j1+1);
        }
    }
}
