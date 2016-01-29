package leetcode.map.zigZagConversion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

/**
 * Created by victor on 16/1/30.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        Map<Integer, List<Character>> map = new HashMap<>();
        int length = s.length();
        boolean flag = true;
        while( length > 0 ){
            if(flag){
                if(map.get(0) == null){
                    map.put(0, new LinkedList<Character>());
                }
                if(length>0){
                    map.get(0).add(s.charAt(s.length()-length));
                    length--;
                }
                flag = false;
            }
            for(int i = 1; i < numRows;i++){
                if(map.get(i) == null){
                    map.put(i, new LinkedList<Character>());
                }
                if(length>0){
                    map.get(i).add(s.charAt(s.length()-length));
                    length--;
                }

            }
            for(int i = numRows-2; i >= 0;i--){
                if(map.get(i) == null){
                    map.put(i, new LinkedList<Character>());
                }
                if(length>0){
                    map.get(i).add(s.charAt(s.length()-length));
                    length--;
                }

            }

        }
        //
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            if(map.get(i)!=null){
                for(Character c:map.get(i)){
                    sb.append(c.toString());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().convert("AB", 1);
        System.out.println(s);
    }
}