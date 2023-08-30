package leetcode.p1525;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numSplits(String s) {
        if (s.length() == 1) {
            return 0;
        }
        int[] prefixCount = new int[s.length()];
        int[] suffixCount = new int[s.length()];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i-1>=0) {
                set.add(s.charAt(i-1));
            }
            prefixCount[i] = set.size();
        }
        set.clear();
        for (int i = s.length()-1; i >= 0; i--) {
            set.add(s.charAt(i));
            suffixCount[i] = set.size();
        }
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (prefixCount[i] == suffixCount[i]) {
                result++;
            }
        }
        return result;
    }
}
