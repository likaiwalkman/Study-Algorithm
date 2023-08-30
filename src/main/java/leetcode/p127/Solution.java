package leetcode.p127;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> verticals = new HashSet<>();
        Map<String, Set<String>> edges = new HashMap<>();
        for (String s : wordList) {
            verticals.add(s);
        }
        verticals.add(beginWord);
        if (!verticals.contains(endWord)){
            return 0;
        }
        ArrayList<String> verticalsNodes = new ArrayList<>(verticals);
        for (int i = 0; i < verticalsNodes.size(); i++) {
            for (int j = i+1; j < verticalsNodes.size(); j++) {
                String base = verticalsNodes.get(i);
                String target = verticalsNodes.get(j);
                int diffCount = 0;
                for (int k = 0; k < base.length(); k++) {
                    if (base.charAt(k) != target.charAt(k)) {
                        diffCount++;
                    }
                }
                if (diffCount == 1) {
                    if (!edges.containsKey(base)) {
                        edges.put(base, new HashSet<>());
                    }
                    edges.get(base).add(target);
                    if (!edges.containsKey(target)) {
                        edges.put(target, new HashSet<>());
                    }
                    edges.get(target).add(base);
                }
            }
        }
        Map<String, Integer> resultMap = new HashMap<>();

        // edges.get(beginWord).contains(endWord)
        //edges.containsKey(beginWord)
        //TODO
        return 0;//
    }
}
