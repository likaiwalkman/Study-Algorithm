package leetcode.p127;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> edges = new HashMap<>();
        Set<String> verticals = new HashSet<>(wordList);
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
        resultMap.put(beginWord, 1);
        List<String> seeds = new ArrayList<>();
        seeds.add(beginWord);
        while (!seeds.isEmpty()){
            List<String> newSeeds = new ArrayList<>();
            for (String seed : seeds) {
                if (!verticals.contains(seed)) {
                    continue;
                }
                if (!edges.containsKey(seed)) {
                    continue;
                }
                verticals.remove(seed);
                Set<String> dests = edges.get(seed);
                for (String dest : dests) {
                    if (!resultMap.containsKey(dest)) {
                        resultMap.put(dest, resultMap.get(seed)+1);
                    }else {
                        Integer oldValue = resultMap.get(dest);
                        if (resultMap.get(seed)+1 < oldValue) {
                            resultMap.put(dest, resultMap.get(seed)+1);
                        }
                    }
                }
                newSeeds.addAll(dests);
            }
            newSeeds.removeIf(i->!verticals.contains(i));
            seeds = newSeeds;
        }
        return resultMap.getOrDefault(endWord, 0);
    }
}
