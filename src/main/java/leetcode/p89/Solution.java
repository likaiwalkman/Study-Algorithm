package leetcode.p89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i <= n; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            for (int k = list.size()-1; k >= 0 ; k--) {
                newList.add(list.get(k)+(1<<(i-1)));
            }
            list = newList;
        }
        return list;
    }
}
