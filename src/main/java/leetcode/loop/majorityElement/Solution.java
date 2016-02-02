package leetcode.loop.majorityElement;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/*
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
* */
/**
 * Created by kai_li on 2016/2/2.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>(new Comparator(){
            public int compare(Object o1, Object o2){
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i2 - i1;
            }
        });
        for(int num:nums){
            Integer numCount = map.get(num);
            numCount = numCount == null ? 0 : numCount;
            numCount++;
            map.put(num, numCount);
        }
        int maxNum =0,maxCount  = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            if (count>maxCount){
                maxNum = key;
                maxCount = count;
            }
        }
        return maxNum;
    }
}