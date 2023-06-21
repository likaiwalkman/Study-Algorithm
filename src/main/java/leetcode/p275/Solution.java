package leetcode.p275;

public class Solution {
    public int hIndex(int[] citations) {
        int count = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[citations.length-1-i] >= i+1) {
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
