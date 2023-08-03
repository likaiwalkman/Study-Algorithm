package leetcode.p228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            int j = i;
            while (j+1 < nums.length && (nums[j] == nums[j+1] || (nums[j] != Integer.MAX_VALUE && nums[j]+1 == nums[j+1]))){
                j++;
            }
            if (i == j) {
                result.add(""+nums[i]);
            }else {
                result.add(nums[i]+"->"+nums[j]);
            }
            i = j+1;
        }
        return result;
    }
}
