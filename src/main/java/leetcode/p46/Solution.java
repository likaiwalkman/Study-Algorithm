package leetcode.p46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        collect(nums, new HashSet<>(), result, new int[nums.length], 0);
        return result;
    }

    public void collect(int[] nums, Set<Integer> visited, List<List<Integer>> result, int[] arr, int n){
        if (visited.size() == nums.length) {
            List<Integer> item = new ArrayList<>();
            for (int i : arr) {
                item.add(i);
            }
            result.add(item);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            arr[n++] = nums[i];

            collect(nums, visited, result, arr, n);

            visited.remove(i);
            n--;
        }
    }
}
