package leetcode.p1545;

public class Solution {
    public char findKthBit(int n, int k) {
        int recursive = recursive(n, k);
        return (char)('0' + recursive);
    }

    public int recursive(int n, int k){
        if(n==1){
            return 0;
        }
        Double powDouble = Math.pow(2, n-1);
        int pow = powDouble.intValue();
        if (k == pow ){
            return 1;
        }else if(k < pow) {
            return recursive(n-1, k);
        }else {
            int v = recursive(n-1, 2*pow-k);
            return v == 1 ? 0 : 1;
        }
    }
}
