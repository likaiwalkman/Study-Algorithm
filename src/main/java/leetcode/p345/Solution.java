package leetcode.p345;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reverseVowels(String s) {
        StringBuilder builder = new StringBuilder();

        int vowelRightIndex = s.length();
        for (int i = 0; i < s.length(); i++) {
            boolean vowel = isVowel(s.charAt(i));
            if (!vowel) {
                builder.append(s.charAt(i));
            }else {
                char rightLetter = s.charAt(--vowelRightIndex);
                while (!isVowel(rightLetter)) {
                    rightLetter = s.charAt(--vowelRightIndex);
                }
                builder.append(rightLetter);
            }
        }
        return builder.toString();
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
