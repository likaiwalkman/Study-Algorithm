package leetcode.p128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int num = nums[i];
            if (map.containsKey(num-1)){
                continue;
            }
            while (map.containsKey(num+1)) {
                count++;
                num++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
