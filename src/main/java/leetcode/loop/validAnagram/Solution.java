package leetcode.loop.validAnagram;
/**

 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

  */


import java.util.HashMap;
import java.util.Map;

/**
 * Created by kai_li on 2016/2/2.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==t){
            return true;
        }else if(t!=null && s==null){
            return false;
        }else if(s!=null && t==null){
            return false;
        } else{
            Map<Character,Integer> m1 = new HashMap<Character,Integer>();
            Map<Character,Integer> m2 = new HashMap<Character,Integer>();
            for(char c : s.toCharArray()){
                Integer cCount = m1.get(c);
                cCount = cCount == null ? 0 : cCount;
                cCount++;
                m1.put(c, cCount);
            }
            for(char c : t.toCharArray()){
                Integer cCount = m2.get(c);
                cCount = cCount == null ? 0 : cCount;
                cCount++;
                m2.put(c, cCount);
            }
            return m1.equals(m2);
        }
    }
}
