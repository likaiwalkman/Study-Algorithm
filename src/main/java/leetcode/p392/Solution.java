package leetcode.p392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        int i = -1;
        int j = -1;
        for (int k = 0; k < s.length(); k++) {
            int j0 = j;
            for (int x = j0+1; x < t.length(); x++) {
                if (t.charAt(x) == s.charAt(k)) {
                    j=x;
                    break;
                }
            }
            if (j == j0) {
                return false;
            }
        }
        return true;
    }
}
