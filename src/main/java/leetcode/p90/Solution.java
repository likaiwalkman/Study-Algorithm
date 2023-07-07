package leetcode.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> totalResult = new ArrayList<>();
        List<Integer> resultItem = new ArrayList<>();
        List<Integer> walkList = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i <= length; i++) {
            iter(nums, walkList, i, totalResult, resultItem);
            System.out.println();
        }
        return totalResult;
    }

    public void iter(int[] nums, List<Integer> walkList, int count, List<List<Integer>> totalResult, List<Integer> resultItem){
        if (count == walkList.size()) {
            totalResult.add(new ArrayList<>(resultItem));
            return;
        }

        if (walkList.isEmpty()){
            int rightBoundary = nums.length-(count-1);
            for (int i = 0; i < rightBoundary;) {
                walkList.add(i);
                resultItem.add(nums[i]);

                iter(nums, walkList, count, totalResult, resultItem);

                walkList.remove(walkList.size()-1);
                resultItem.remove(resultItem.size()-1);

                int i0 = i+1;
                while (i0 < nums.length-(count-1) && nums[i0] == nums[i]) {
                    i0++;
                }
                i=i0;
            }
        }else {
            Integer lastFootprint = walkList.get(walkList.size() - 1);
            for (int i = lastFootprint + 1; i < nums.length;) {
                walkList.add(i);
                resultItem.add(nums[i]);

                iter(nums, walkList, count, totalResult, resultItem);

                walkList.remove(walkList.size()-1);
                resultItem.remove(resultItem.size()-1);

                int i0 = i+1;
                while (i0 < nums.length && nums[i0] == nums[i]) {
                    i0++;
                }
                i=i0;
            }
        }

    }
}
