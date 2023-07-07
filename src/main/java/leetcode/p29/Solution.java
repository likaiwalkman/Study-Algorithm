package leetcode.p29;

public class Solution {
    public static void main(String[] args) {
        int divide = new Solution().divide(-2147483648, -1);
        System.out.println(divide);
    }
    public int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE){
            return 1;
        }
        if (dividend > 0 && divisor > 0){
            int result = 0;
            while ( (dividend -= divisor) >= 0) {
                result++;
            }
            return result;
        }else if (dividend < 0 && divisor < 0){
            int result = 0;
            while ( (dividend -= divisor) <= 0) {
                result++;
            }
            return result;
        }else {
            if (dividend > 0){
                int result = 0;
                while ( (dividend += divisor) >= 0) {
                    result--;
                }
                return result;
            }else {
                int result = 0;
                while ( (dividend += divisor) <= 0) {
                    result--;
                }
                return result;
            }
        }
    }
}
