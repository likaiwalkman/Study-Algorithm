package leetcode.p78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        int total = 1;
        for (int i = 0; i < nums.length; i++) {
            total  = total << 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i < total; i++) {
            List<Integer> indices = new ArrayList<>();
            int k = i;
            while (k != 0){
                indices.add(k%2);
                k = k / 2;
            }
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < indices.size(); j++) {
                if (indices.get(j) == 1) {
                    item.add(nums[j]);
                }
            }
            result.add(item);
        }
        return result;
    }
}
