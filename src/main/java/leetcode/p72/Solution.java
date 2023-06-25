package leetcode.p72;

public class Solution {
    public int minDistance(String word1, String word2) {
        int w1Len = word1.length();
        int w2Len = word2.length();

        int[][] result = new int[w1Len+1][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[word2.length()+1];
        }

        for (int i = 0; i < word1.length() + 1; i++) {
            result[i][0] = i;
        }

        for (int i = 0; i < word2.length() + 1; i++) {
            result[0][i] = i;
        }

        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    result[i][j] = result[i-1][j-1];
                }else {
                    int a = result[i-1][j];
                    int b = result[i][j-1];
                    int c = result[i-1][j-1];

                    int min = a;
                    if (b < min) {
                        min = b;
                    }
                    if (c < min) {
                        min = c;
                    }
                    result[i][j] = min+1;
                }
            }
        }

        return result[w1Len][w2Len];
    }
}
