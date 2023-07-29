package leetcode.p49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] ints = new int[26];
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                ints[(int)(str.charAt(j)-'a')]++;
            }
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < ints.length; k++) {
                if (ints[k] != 0) {
                    builder.append((char)('a'+k));
                    builder.append(ints[k]);
                }
            }
            String key = builder.toString();
            if (!maps.containsKey(key)) {
                maps.put(key, new ArrayList<>());
            }
            maps.get(key).add(str);
        }
        List<List<String>> lists = new ArrayList<>(maps.values());
        return lists;
    }
}
