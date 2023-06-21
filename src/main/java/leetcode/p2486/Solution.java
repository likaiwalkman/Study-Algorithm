package leetcode.p2486;

public class Solution {
    public int appendCharacters(String s, String t) {
        int longestCommonSequenceCount = 0;
        for (int i=0,j=0; i < s.length() && j< t.length();){
            if (s.charAt(i) == t.charAt(j)) {
                longestCommonSequenceCount++;
                i++;
                j++;
            }else {
                i++;
            }
        }
        return t.length() - longestCommonSequenceCount;
    }
}
