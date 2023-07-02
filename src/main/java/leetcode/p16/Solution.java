package leetcode.p16;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int[] components = new int[3];
        int count = 0;
        int[] resultAndDiff = new int[2];
        resultAndDiff[1] = Integer.MAX_VALUE;

        iter(nums, target, 0, components, resultAndDiff);
        return resultAndDiff[0];
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;

        for (int i = 0; i <= nums.length-3; i++) {
            int j = i+1;
            int k = nums.length-1;

            if (i>1 && nums[i] == nums[i-1] ){
                continue;
            }

            do {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == target) {
                    return target;
                }
                int absDiff = Math.abs( sum - target);
                if (sum < target){
                    //j++;
                    int j0 = j+1;
                    while (j0 < k && nums[j0] == nums[j]){
                        j0++;
                    }
                    j = j0;
                }else {
                    //k--;
                    int k0 = k-1;
                    while (k0 > j && nums[k0]==nums[k]){
                        k0--;
                    }
                    k = k0;
                }
                if (minDiff > absDiff) {
                    minDiff = absDiff;
                    closestSum = sum;
                }
            }while (k-j>0);

        }
        return closestSum;
    }

    public void iter(int[] nums, int target, int count, int[] components, int[] resultAndDiff){
        if (count == 3) {
            int item = nums[components[0]]+nums[components[1]]+nums[components[2]];
            int _diff = Math.abs(item-target);
            if (_diff < resultAndDiff[1]) {
                resultAndDiff[1] = _diff;
                resultAndDiff[0] = item;
            }
            return;
        }

        int start = 0;
        if (count != 0){
            start = components[count-1]+1;
        }

        for (int i = start; i < nums.length; i++) {

            components[count] = i;
            count++;

            iter(nums, target, count, components, resultAndDiff);

            count--;
            components[count] = 0;
        }
    }
}
