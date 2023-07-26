package leetcode.p1143;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length()==0){
            return 0;
        }
        int[][] array = new int[text1.length()+1][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[text2.length()+1];
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    array[i][j] = array[i-1][j-1] + 1;
                }else {
                    if (array[i-1][j] > array[i][j-1]) {
                        array[i][j] = array[i-1][j];
                    }else {
                        array[i][j] = array[i][j-1];
                    }
                }
            }
        }
        return array[text1.length()][text2.length()];
    }
}
