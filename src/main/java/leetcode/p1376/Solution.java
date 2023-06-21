package leetcode.p1376;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> parentMap = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int managerId = manager[i];
            if (managerId == -1) {
                continue;
            }
            if (!parentMap.containsKey(managerId)) {
                parentMap.put(managerId, new ArrayList<Integer>());
            }
            parentMap.get(managerId).add(i);
        }

        Map<Integer, Integer> timeMap = new HashMap<>();
        for (int i = 0; i < informTime.length; i++) {
            timeMap.put(i, informTime[i]);
        }

        List<int[]> result = new ArrayList<>();
        List<int[]> headers = new ArrayList<>();
        headers.add(new int[]{headID, 0});
        while (headers != null && headers.size() > 0){
            List<int[]> newHeaders = new ArrayList<>();
            for (int[] headerArr : headers) {
                List<Integer> children = parentMap.get(headerArr[0]);
                if (children == null) {
                    result.add(headerArr);
                    continue;
                }
                Integer cost = timeMap.get(headerArr[0]);

                //timeTotal += cost;
                for (Integer child : children) {
                    int [] childArr = new int[]{child, headerArr[1]+cost};
                    newHeaders.add(childArr);
                }
            }
            headers = newHeaders;
        }
        int finalResult = 0;
        for (int[] ints : result) {
            finalResult = ints[1] > finalResult ? ints[1] : finalResult;
        }

        return finalResult;
    }
}
