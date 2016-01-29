package leetcode.loop.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;
/*
  Given a string, find the length of the longest substring without repeating characters.
  For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
  For "bbbbb" the longest substring is "b", with the length of 1.
*/

/**
 * Created by victor on 16/1/30.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        s = s == null || "".equals(s) ? "" : s;
        char[] chars = s.toCharArray();
        int length = chars.length;
        int num = 0;
        for(int i=0;i<length;i++){
            Set<Character> set = new HashSet();
            int temp = 0;
            for(int j =i;j<length;j++){
                if(set.contains(chars[j])){
                    num = temp > num ? temp : num;
                    break;
                } else {
                    set.add(chars[j]);
                    temp++;
                }
                if(j==length-1){
                    num = temp > num ? temp : num;
                }
            }
        }
        Character c = 'c';
        c.toString();
        return num;
    }
}
