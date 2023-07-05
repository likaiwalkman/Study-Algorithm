package leetcode.p1137;

public class Solution {
    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }

        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 1;
        for (int i = 3; i <= n; i++) {
            ints[i] = ints[i-1] + ints[i-2]+ints[i-3];
        }
        return ints[n];
    }
}
