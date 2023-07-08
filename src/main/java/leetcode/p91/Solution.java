package leetcode.p91;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    static Set<String> set = new HashSet<>();
    static {
        for (int i = 1; i <= 26; i++) {
            set.add(i+"");
        }
    }
    public int numDecodings(String s) {
        int[] ints = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.length()-1-i;
            String character = s.substring(pos, pos + 1);

            int result = 0;
            if (set.contains(character)){
                if (pos == s.length()-1) {
                    result++;
                }else {
                    result += ints[i-1];
                }
            }

            if (pos + 1 < s.length()) {
                character = s.substring(pos, pos + 2);
                if (set.contains(character)){
                    if (pos+1 == s.length()-1) {
                        result++;
                    }else {
                        result += ints[i-2];
                    }
                }
            }
            ints[i] = result;
        }
        return ints[s.length()-1];
    }
}
