package leetcode.p96;

public class Solution {
    public int numTrees(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        if (n <=1) {
            return arr[n];
        }

        for (int i=2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                int ltCnt = (j-1);
                int gtCnt = (i-j);
                if (ltCnt == 0 || gtCnt == 0){
                    sum += arr[ltCnt] + arr[gtCnt];
                }else {
                    sum += arr[ltCnt] * arr[gtCnt];
                }
            }
            arr[i] = sum;
        }
        return arr[n];
    }
}
