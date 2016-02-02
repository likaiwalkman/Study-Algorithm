package leetcode.loop.containsDuplicate;
/**
 Given an array of integers, find if the array contains any duplicates.
 Your function should return true if any value appears at least twice in the array,
 and it should return false if every element is distinct.
 * */

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kai_li on 2016/2/2.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if( nums == null || nums.length <= 1){
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            } else {
                set.add(num);
            }
        }
        return false;

    }
}
