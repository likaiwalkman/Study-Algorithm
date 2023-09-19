package leetcode.p1456;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final Set<Character> vowels = new HashSet<>();
    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public int maxVowels(String s, int k) {
        int n = s.length();
        int vowelsCount = 0;
        int max = 0;

        for (int j = 0; j < k; j++) {
            if (vowels.contains(s.charAt(j))) {
                vowelsCount++;
            }
        }
        if (vowelsCount == k){
            return k;
        }
        max = vowelsCount;

        for (int i = k; i < n; i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelsCount++;
            }
            if (vowels.contains(s.charAt(i-k))) {
                vowelsCount--;
            }
            if (vowelsCount > max) {
                max = vowelsCount;
            }
            if (max == k) {
                return k;
            }
        }
        return max;

    }
}
