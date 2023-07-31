package leetcode.p274;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for (int i = citations.length-1; i >= 0; i--) {
            if (citations[i] >= citations.length-i) {
                max = citations.length - i;
            }else {
                break;
            }
        }
        return max;
    }
}
