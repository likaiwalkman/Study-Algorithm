package leetcode.p433;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Integer> visitedRecordMap = new HashMap<>();
        if (bank != null) {
            for (String mutation : bank) {
                visitedRecordMap.put(mutation, 0);
            }
        }
        if (!visitedRecordMap.containsKey(endGene)) {
            return -1;
        }

        int count = 0;
        List<String> edges = new ArrayList<>();
        edges.add(startGene);

        while ( ! edges.contains(endGene) && ! edges.isEmpty()){
            List<String> nextEdges = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : visitedRecordMap.entrySet()) {
                if (entry.getValue() == 1) {
                    continue;
                }
                String key = entry.getKey();
                for (String edge : edges) {
                    if (letterDiffCount(key, edge) == 1) {
                        nextEdges.add(key);
                        entry.setValue(1);
                    }
                }
            }

            count++;
            edges = nextEdges;
        }
        if (edges.contains(endGene)) {
            return count;
        }else {
            return -1;
        }

    }

    private static int letterDiffCount(String a, String b){
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) != a.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
