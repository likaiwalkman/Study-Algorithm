package leetcode.loop.threeSum;

import java.util.*;

/**
 * Created by kai_li on 2016/2/1.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if ( nums == null || nums.length < 3){
            return new LinkedList<List<Integer>>();
        }
        Set<Map<Integer, Object>> sets = new HashSet<Map<Integer, Object>>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Object> map = new IdentityHashMap<Integer, Object>();
            for (int j = i+1; i < nums.length; i++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k] == 0){
                        map.put(new Integer(nums[i]), null);
                        map.put(new Integer(nums[j]), null);
                        map.put(new Integer(nums[k]), null);
                        sets.add(map);
                        map = new IdentityHashMap<Integer, Object>();
                    }
                }
            }
        }
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        List<Integer> solution = new LinkedList<Integer>();
        Iterator<Map<Integer, Object>> iterator = sets.iterator();
        while (iterator.hasNext()){
            IdentityHashMap<Integer,Object> map = (IdentityHashMap)iterator.next();
            Iterator<Map.Entry<Integer,Object>> citerator = map.entrySet().iterator();
            while (citerator.hasNext()){
                solution.add(citerator.next().getKey());
            }
            list.add(solution);
        }
        return list;
    }

    public static void main(String[] args) {
        List list = new Solution().threeSum(new int[]{2,1,-3,3,-3,1,2,2});
        System.out.println(list);
    }
}
