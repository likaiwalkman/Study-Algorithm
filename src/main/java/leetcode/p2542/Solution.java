package leetcode.p2542;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] paris = new int[n][];
        for (int i = 0; i < nums1.length; i++) {
            paris[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(paris, (o1, o2) -> (o2[1] - o1[1]));

        long a = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int j = 0; j <= k - 1; j++) {
            heap.offer(paris[j][0]);
            a += paris[j][0];
        }
        long result = a * paris[k-1][1];

        for (int i = k; i < paris.length; i++) {
            int[] pair = paris[i];
            a -= heap.poll();
            heap.offer(pair[0]);
            a += pair[0];


            long partialResult = a * pair[1];
            if (partialResult > result) {
                result = partialResult;
            }
        }
        return result;
    }
}
