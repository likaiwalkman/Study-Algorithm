package leetcode.p137;

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        int lift = 31;
        int SIZE = 32;
        while (SIZE > 0){
            int digitSum = 0;
            for (int num : nums) {
                digitSum += (num >>> lift) & 1;
            }

            result = result << 1;
            result += digitSum % 3;

            SIZE--;
            lift--;
        }
        return result;
    }
}
