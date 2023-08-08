package leetcode.p207;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
            return true;
        }
        Map<Integer,Integer> entryCountMap = new HashMap<>();
        List<int[]> edges = new ArrayList<>();
        Set<Integer> courses = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            if (entryCountMap.containsKey(a)) {
                entryCountMap.put(a, entryCountMap.get(a)+1);
            }else {
                entryCountMap.put(a, 1);
            }
            edges.add(prerequisite);
        }
        boolean flag = true;
        while (!edges.isEmpty() && flag) {
            List<int[]> leftEdges = new ArrayList<>();
            flag = false;
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                if (!entryCountMap.containsKey(b)){
                    flag = true;
                    courses.add(b);
                    if (entryCountMap.containsKey(a)) {
                        Integer cnt = entryCountMap.get(a);
                        if (cnt == 1) {
                            courses.add(a);
                            entryCountMap.remove(a);
                        }else {
                            entryCountMap.put(a, cnt-1);
                        }
                    }

                }else {
                    leftEdges.add(edge);
                }
            }
            edges = leftEdges;
        }
        return courses.size() >= numCourses || edges.size() == 0;
    }
}
