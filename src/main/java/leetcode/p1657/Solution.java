package leetcode.p1657;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            if (!map1.containsKey(c1)) {
                map1.put(c1, 1);
            }else {
                map1.put(c1, 1+map1.get(c1));
            }

            char c2 = word2.charAt(i);
            if (!map2.containsKey(c2)) {
                map2.put(c2, 1);
            }else {
                map2.put(c2, 1+map2.get(c2));
            }
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        List<Integer> list1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> list2 = map2.values().stream().sorted().collect(Collectors.toList());
        if (!list1.equals(list2)) {
            return false;
        }
        return true;
    }
}
