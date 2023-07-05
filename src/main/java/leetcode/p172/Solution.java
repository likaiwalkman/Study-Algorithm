package leetcode.p172;

public class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int k = i;
            int j = 0;
            while (k != 0 && k % 5 == 0){
                j++;
                k /= 5;
            }
            sum += j;
        }
        return sum;
    }
}
