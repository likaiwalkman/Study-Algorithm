package leetcode.p187;

import java.util.*;

public class Solution {
    static String intToStr(int num){
        Stack<Character> stack = new Stack<>();
        for (int k = 0; k < 10; k++) {
            char c = CHARS[num % 4];
            stack.push(c);
            num = num / 4;
        }
        StringBuilder builder = new StringBuilder();
        while (stack.size() > 0) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
    static int charToInt(char c){
        int inc = 0;
        switch (c){
            case 'C':
                inc = 1;
                break;
            case 'G':
                inc = 2;
                break;
            case 'T':
                inc = 3;
                break;
        }
        return inc;
    }
    static char[] CHARS = new char[]{'A', 'C', 'G', 'T'};
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }
        char[] top10Chars = s.substring(0, 10).toCharArray();
        int tenCharInt = 0;
        for (char top10Char : top10Chars) {
            int inc = charToInt(top10Char);
            tenCharInt *= 4;
            tenCharInt += inc;
        }
        int truncator = 1 << 18;
        int[] slots = new int[1<< 21];
        slots[tenCharInt]++;
        int length = s.length();
        for (int i = 10; i < length; i++) {
            tenCharInt = tenCharInt % truncator;
            tenCharInt *= 4;
            char var = s.charAt(i);
            int inc = charToInt(var);
            tenCharInt += inc;
            String slice = intToStr(tenCharInt);
            slots[tenCharInt]++;
        }
        List<String> result = new ArrayList<>();

        for (int i = 0; i < slots.length; i++) {
            if (slots[i] >= 2){
                result.add(intToStr(i));
            }
        }
        return result;
    }
}
