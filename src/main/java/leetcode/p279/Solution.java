package leetcode.p279;

public class Solution {
    public int numSquares(int n) {

        int[] arr = new int[n+1];
        arr[0] = 0;

        for(int num = 1; num <= n;num++){
            Double sqrt = Math.sqrt(num);
            int sqrtInt = sqrt.intValue();

            int minCount = Integer.MAX_VALUE;
            for (int k = 1; k <= sqrtInt; k++) {
                int count =  1 + arr[num-k*k];
                if (count < minCount) {
                    minCount = count;
                }
            }
            arr[num] = minCount;
        }

        return arr[n];

    }
}
