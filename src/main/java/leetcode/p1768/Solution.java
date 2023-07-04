package leetcode.p1768;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1Count = 0;
        int w2Count = 0;

        StringBuilder builder = new StringBuilder();
        while (w1Count + w2Count < word1.length() + word2.length()) {
            if (w1Count == word1.length()) {
                builder.append(word2.charAt(w2Count++));
                continue;
            }

            if (w2Count == word2.length()) {
                builder.append(word1.charAt(w1Count++));
                continue;
            }
            if ((w1Count + w2Count) % 2 == 0) {
                builder.append(word1.charAt(w1Count++));
            }else {
                builder.append(word2.charAt(w2Count++));
            }
        }
        return builder.toString();
    }
}
