package leetcode.p1332;

public class Solution {
    public int removePalindromeSub(String s) {
        boolean symmetric = true;
        for (int i = 0; i < s.length()/2; i++) {
            int right = s.length()-1-i;
            if (s.charAt(i) != s.charAt(right)) {
                symmetric = false;
                break;
            }
        }
        if (symmetric){
            return 1;
        }else {
            return 2;
        }
    }
}
