package leetcode.loop.longestPalindromicSubString;

/*
    Longest Palindromic Substring

    Given a string S, find the longest palindromic substring in S.
    You may assume that the maximum length of S is 1000,
    and there exists one unique longest palindromic substring.
*/
/**
 * Created by victor on 16/1/31.
 */
public class Solution {
    public String longestPalindrome(String s) {
        s = s == null || "".equals(s) ? "" : s;
        char[] chars = s.toCharArray();
        int f = 0, e = 0, num = 0;
        int length = chars.length;
        for(int i = 0; i < length ; i++){
            //f = e = i;
            int count=0, steps = 0;
            while( (i-count-1) >=0 && (i+count+1) <= length-1 && chars[(i-count-1)] == chars[(i+count+1)]){
                count++;
                steps = steps + 2;
            }
            if(steps + 1 > num){
                num = steps + 1;
                f = i - count;
                e = i + count;
            }
            if( i+1 < length && chars[i] == chars[i+1]){
                count = 0;
                steps = 1;
                while( (i-count-1) >=0 && (i+count+2) <= length-1 && chars[(i-count-1)] == chars[(i+count+2)]){
                    count++;
                    steps = steps + 2;
                }
                if(steps + 1 > num){
                    num = steps + 1;
                    f = i - count;
                    e = i + count+1;
                }
            }
        }
        return s.substring(f, e+1);
    }
}
