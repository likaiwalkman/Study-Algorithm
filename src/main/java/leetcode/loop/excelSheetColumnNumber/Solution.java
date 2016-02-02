package leetcode.loop.excelSheetColumnNumber;
/**
 *
 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28

 * */

/**
 * Created by kai_li on 2016/2/2.
 */
public class Solution {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for(int i = chars.length - 1; i >= 0 ; i--){
            sum += Math.pow(26, chars.length -1 - i )  * (int)(chars[i] - 'A' + 1 );
        }
        return sum;
    }
}
