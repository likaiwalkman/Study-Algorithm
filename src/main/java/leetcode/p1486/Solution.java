package leetcode.p1486;

public class Solution {
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        int result = start;
        for (int i = 1; i < arr.length; i++) {
            int num = start + 2*i;
            arr[i] = num;
            result = result ^ num;
        }
        return result;
    }
}
