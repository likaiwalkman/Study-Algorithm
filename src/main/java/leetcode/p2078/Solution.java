package leetcode.p2078;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxDistance(int[] colors) {
        List<int[]> list= new ArrayList<>();
        int cursor = 0;
        while (cursor < colors.length){
            int cursorEnd = cursor;
            while (cursorEnd + 1 < colors.length && colors[cursorEnd + 1] == colors[cursorEnd]) {
                cursorEnd++;
            }
            list.add(new int[]{colors[cursor], cursor, cursorEnd});
            cursor = cursorEnd+1;
        }

        Integer maxDistance = null;
        for (int i = 0; i < list.size(); i++) {
            int[] prev = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                int[] next = list.get(j);
                if (next[0] != prev[0]) {
                    int partialMax = next[2]-prev[1];
                    if (maxDistance == null) {
                        maxDistance = partialMax;
                    }else {
                        maxDistance = Math.max(partialMax, maxDistance);
                    }
                }
            }
        }
        return maxDistance;
    }
}
