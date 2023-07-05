package leetcode.p1207;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }else {
                map.put(i, map.get(i)+1);
            }
        }
        int keySize = map.keySet().size();
        int timesSet = map.values().stream().collect(Collectors.toSet()).size();
        return keySize == timesSet;
    }
}
