package leetcode.p120;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 1){
            return triangle.get(0).get(0);
        }
        List<Integer> assitant = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> assistantNext = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                int item = list.get(j);
                Integer oldValue = null;
                if (j < assitant.size()){
                    oldValue = assitant.get(j);
                }
                Integer prevVal = null;
                if (j-1 >= 0 && j-1 < assitant.size()) {
                    prevVal = assitant.get(j-1);
                }
                if (oldValue == null && prevVal == null){
                    //do nothing
                }else if (oldValue == null && prevVal != null){
                    item += prevVal;
                }else if(oldValue != null && prevVal != null){
                    item += Math.min(oldValue, prevVal);
                }else {
                    item += oldValue;
                }
                assistantNext.add(item);
            }
            assitant = assistantNext;
        }
        int minSum = assitant.get(0);
        for (int i = 1; i < assitant.size(); i++) {
            if (assitant.get(i) < minSum) {
                minSum = assitant.get(i);
            }
        }

        return minSum;
    }
}
