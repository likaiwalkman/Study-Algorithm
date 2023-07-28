package leetcode.p2395;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean findSubarrays(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int k = 1; k < nums.length; k++) {
            int v = nums[k-1]+nums[k];
            if (set.contains(v)) {
                return true;
            }else {
                set.add(v);
            }
        }
        return false;
    }
}
