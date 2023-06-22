package leetcode.p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if(left == nums[i]){
                if (map.containsKey(nums[i]) && map.get(nums[i]).size() > 1) {
                    List<Integer> integers = map.get(nums[i]);
                    return new int[]{integers.get(0), integers.get(1)};
                }
            }else {
                if (map.containsKey(nums[i]) && map.containsKey(left)) {
                    List<Integer> a = map.get(nums[i]);
                    List<Integer> b = map.get(left);
                    return new int[]{a.get(0), b.get(0)};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
