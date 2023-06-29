package leetcode.p9;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int k = x;
        int val = 0;
        while (k != 0){
            val = val * 10 + k % 10;
            k /= 10;
        }
        return val == x;
    }
}
