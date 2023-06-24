package leetcode.p39;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> visitedIndex = new ArrayList<>();
        List<Integer> partialResult = new ArrayList<>();


        recursive(candidates, result, visitedIndex, partialResult,  target);

        return result;
    }

    public void recursive(int[] nums, List<List<Integer>> result, List<Integer> visitedIndex, List<Integer> partialResult, int target){
        if (target < 0){
            return;
        }
        if (0 == target) {
            result.add(new ArrayList<>(partialResult));
            return;
        }

        int begin = 0;
        if (visitedIndex.size() > 0) {
            begin = visitedIndex.get(visitedIndex.size()-1);
        }
        for (int i = begin; i < nums.length; i++) {
            visitedIndex.add(i);
            target -= nums[i];
            partialResult.add(nums[i]);

            recursive(nums, result, visitedIndex, partialResult, target);

            visitedIndex.remove(visitedIndex.size()-1);
            target += nums[i];
            partialResult.remove(partialResult.size()-1);
        }

    }
}
