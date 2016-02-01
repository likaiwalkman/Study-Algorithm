package leetcode.bit.singleNumber;

/*
*
    Given an array of integers, every element appears twice except for one. Find that single one.
*/
/**
 * Created by victor on 16/2/2.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i=0;i<nums.length;i++){
            num = num ^ nums[i];
        }
        return num;
    }
}