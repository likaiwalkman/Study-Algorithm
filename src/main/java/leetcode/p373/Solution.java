package leetcode.p373;

import java.util.*;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minRootHeap = new PriorityQueue<>((o1, o2) -> {
            if ((nums1[o1[0]] + nums2[o1[1]]) < (nums1[o2[0]] + nums2[o2[1]])){
                return -1;
            }else if ((nums1[o1[0]] + nums2[o1[1]]) > (nums1[o2[0]] + nums2[o2[1]])){
                return 1;
            }else {
                return 0;
            }
        });

        int num1Len = nums1.length;
        int num2Len = nums2.length;

        Map<Long, Boolean> map = new HashMap<>();
        minRootHeap.offer(new int[]{0, 0});
        map.put(0L, true);

        List<List<Integer>> result = new ArrayList<>();
        while (!minRootHeap.isEmpty() && k > 0) {
            int[] poll = minRootHeap.poll();
            k--;
            int num1Index = poll[0];
            int num2Index = poll[1];
            List<Integer> item = new ArrayList<>();
            item.add(nums1[num1Index]);
            item.add(nums2[num2Index]);
            result.add(item);

            if (num1Index+1 < num1Len) {
                long key = num1Index+1;
                key = key << 32;
                key |= num2Index;
                if (!map.containsKey(key)) {
                    map.put(key, true);
                    minRootHeap.offer(new int[]{num1Index+1, num2Index});
                }
            }
            if (num2Index+1 < num2Len) {
                long key = num1Index;
                key = key << 32;
                key |= num2Index+1;
                if (!map.containsKey(key)) {
                    map.put(key, true);
                    minRootHeap.offer(new int[]{num1Index, num2Index+1});
                }
            }

        }
        return result;
    }
}
