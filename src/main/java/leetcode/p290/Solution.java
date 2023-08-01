package leetcode.p290;

import java.util.*;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        LinkedHashMap<Character, List<Integer>> patterns = new LinkedHashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!patterns.containsKey(c)) {
                patterns.put(c, new ArrayList<>());
            }
            patterns.get(c).add(i);
        }
        LinkedHashMap<String, List<Integer>> target = new LinkedHashMap<>();
        String[] split = s.split(" ");
        if (split != null && split.length > 0) {
            for (int i = 0; i < split.length; i++) {
                String str = split[i];
                if (!target.containsKey(str)) {
                    target.put(str, new ArrayList<>());
                }
                target.get(str).add(i);
            }
        }
        if (patterns.size() != target.size()){
            return false;
        }
        List<List<Integer>> patternValues = new ArrayList<>();
        for (Map.Entry<Character, List<Integer>> entry : patterns.entrySet()) {
            patternValues.add(entry.getValue());
        }

        List<List<Integer>> targetValues = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : target.entrySet()) {
            targetValues.add(entry.getValue());
        }
        return patternValues.equals(targetValues);
    }
}
