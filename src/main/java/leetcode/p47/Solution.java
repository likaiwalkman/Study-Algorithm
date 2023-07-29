package leetcode.p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> visitedPath = new ArrayList<>();
        Arrays.sort(nums);
        iter(results, nums, visitedPath);
        return results;
    }

    private void iter(List<List<Integer>> results, int[] nums, List<Integer> visitedPath){
        if (visitedPath.size() == nums.length) {
            List<Integer> item = visitedPath.stream().map(index -> nums[index]).collect(Collectors.toList());
            results.add(item);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visitedPath.contains(i)) {
                continue;
            }
            visitedPath.add(i);
            boolean flag = false;
            for (Integer integer : visitedPath) {
                if (integer-1 >=0 && !visitedPath.contains(integer-1) && nums[integer-1] == nums[integer]){
                    flag  = true;
                    break;
                }
            }
            if (flag){
                visitedPath.remove(visitedPath.size()-1);
                continue;
            }

            iter(results, nums, visitedPath);
            visitedPath.remove(visitedPath.size()-1);
        }
    }
}
