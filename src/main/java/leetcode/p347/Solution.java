package leetcode.p347;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> integers = topKFrequentElement(nums, k);
        if (integers.isEmpty()) {
            return new int[0];
        }else {
            int[] ints = new int[integers.size()];
            for (int i = 0; i < integers.size(); i++) {
                ints[i] = integers.get(i);
            }
            return ints;
        }
    }

    private List<Integer> topKFrequentElement(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, 1 + map.get(num));
            }
        }
        int size = map.size();
        int[][] pairs = new int[size][];
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        int count = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            pairs[count++] = new int[]{entry.getKey(), entry.getValue()};
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int[] pair : pairs) {
            heap.offer(pair);
        }

        List<Integer> results = new ArrayList<>();
        while (k != 0 && !heap.isEmpty()) {
            int[] poll = heap.poll();
            results.add(poll[0]);
            k--;
        }
        return results;
    }
}
