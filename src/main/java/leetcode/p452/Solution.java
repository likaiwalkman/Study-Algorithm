package leetcode.p452;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        LinkedList<int[]> linkedList = new LinkedList<>(Arrays.asList(points));

        int count = 0;
        while (!linkedList.isEmpty()){
            Iterator<int[]> iterator = linkedList.iterator();
            count++;
            int[] base = null;
            while (iterator.hasNext()) {
                int[] cursor = iterator.next();
                if (base == null) {
                    base = cursor;
                    iterator.remove();
                }else {
                    if (cursor[0] <= base[1]) {
                        iterator.remove();
                    }
                }
            }
        }

        return count;
    }
}
