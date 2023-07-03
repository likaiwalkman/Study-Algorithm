package leetcode.p7;

public class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int result = 0;
        while (x != 0){
            result = x % 10 + result * 10;
            x /= 10;
            if (x != 0 && (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10 ) ) {
                return 0;
            }
            if (result == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10) {
                return 0;
            }

            if (result == Integer.MIN_VALUE / 10 && x % 10 < Integer.MIN_VALUE % 10) {
                return 0;
            }
        }

        return result;
    }
}
