package leetcode.p191;

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int SIZE = 32;
        while (SIZE > 0) {
            if (n % 2 != 0) {
                count++;
            }
            SIZE--;
            n = n >>> 1;
        }
        return count;
    }
}
