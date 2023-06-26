package leetcode.p17;


import java.util.*;

public class Solution {
    static Map<Character, char[]> map = new HashMap<>();
    static {
        //map.put('2', new String[]{"a", "b", "c"});
        for (int i = 2; i <= 6 ; i++) {
            map.put((char)('2'+(i-2)), new char[]{(char)('a' + (i-2)*3), (char)('b' + (i-2)*3), (char)('c' + (i-2)*3)});
        }


        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        char[][] chars = new char[digits.length()][];
        for (int i = 0; i < digits.length(); i++) {
            chars[i] = map.get(digits.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        Set<String> result = new HashSet<>();

        collect(builder, result, chars);
        return new ArrayList<>(result);
    }

    public void collect(StringBuilder builder, Set<String> result, char[][] chars){
        if (builder.length() == chars.length) {
            result.add(builder.toString());
            return;
        }

        int charArrIndex = builder.length();
        char[] charArr = chars[charArrIndex];

        for (int i = 0; i < charArr.length; i++) {
            builder.append(charArr[i]);
            collect(builder, result, chars);
            builder.deleteCharAt(builder.length()-1);
        }
    }


}
