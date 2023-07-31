package leetcode.p219;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k==0){
            return false;
        }
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, Integer.MAX_VALUE});
            }else {
                int[] ints = map.get(nums[i]);
                if (i - ints[0] < ints[1]) {
                    ints[1] = i - ints[0];
                }
                ints[0] = i;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            int[] ints = map.get(nums[i]);
            if (ints[0] != Integer.MAX_VALUE && ints[1] <= k) {
                return true;
            }
        }
        return false;
    }
}
