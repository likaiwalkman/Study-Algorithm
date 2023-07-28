package leetcode.p70;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int[] ints = new int[n];
        ints[0] = 1;
        ints[1] = 2;

        for (int i = 2; i < n; i++) {
            ints[i] = ints[i-1] + ints[i-2];
        }
        return ints[n-1];
    }
}
