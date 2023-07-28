package leetcode.p69;

public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }

        int i = 1;
        int j = x;

        while (i != j){

            int xj = x / j;
            int xi = x / i;
            if (xj == j) {
                return j;
            }else if (xi == i) {
                return i;
            }else if (xi > i && xj < j && i == j-1){
                return i;
            }else {
                int mid = (i + j )/ 2;
                int xmid = x / mid;
                if (xmid > mid) {
                    i = mid;
                }else if (xmid < mid){
                    j = mid;
                }else {
                    return mid;
                }
            }
        }
        return 0;
    }
}
