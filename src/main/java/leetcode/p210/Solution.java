package leetcode.p210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
            int[] ints = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ints[i] = i;
            }
            return ints;
        }
        Map<Integer,Integer> entryCountMap = new HashMap<>();
        List<int[]> edges = new ArrayList<>();
        LinkedHashSet<Integer> courses = new LinkedHashSet<>();
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
        if (!edges.isEmpty()) {
            return new int[]{};
        }

        for (int i = 0; i < numCourses; i++) {
            if (!courses.contains(i)) {
                courses.add(i);
            }
        }

        int[] ints = new int[numCourses];
        int count = 0;
        for (Integer courseId : courses) {
            ints[count++] = courseId;
        }
        return ints;
    }
}
