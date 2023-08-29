package leetcode.p502;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> components = new ArrayList<>();
        for (int i = 0; i < capital.length; i++) {
            components.add(new int[]{capital[i], profits[i]});
        }

        Collections.sort(components, Comparator.comparingInt(o -> o[0]));

        while (k > 0 && !components.isEmpty() && w >= components.get(0)[0]){
            int LIST_SIZE = components.size();
            int start = 0;
            int end = LIST_SIZE-1;
            while (start != end && components.get(end)[0] > w) {
                int mid = (start + end) / 2;
                if (components.get(mid)[0] > w){
                    end = mid;
                    continue;
                }else {
                    if (components.get(mid+1)[0] > w){
                        end = mid;
                        break;
                    }else {
                        start = mid+1;
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            int rightIndex = -1;
            for (int i = 0; i <= end; i++) {
                if (components.get(i)[1] > max) {
                    max = components.get(i)[1];
                    rightIndex = i;
                }
            }
            k--;
            components.remove(rightIndex);
            w += max;
        }
        return w;
    }
}
