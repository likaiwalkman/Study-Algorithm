package leetcode.p338;

public class Solution {
    public int[] countBits(int n) {
        if (n == 0){
            return new int[]{0};
        }
        if(n == 1){
            return new int[]{0,1};
        }
        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                ints[i] = ints[i-1] + 1;
            }else {
                ints[i] = ints[i/2];
            }
        }

        return ints;
    }
}
