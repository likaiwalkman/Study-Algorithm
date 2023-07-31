package leetcode.p202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        if (n==1){
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int x = n;
        while (!set.contains(x)){
            set.add(x);
            int temp = 0;
            while (x != 0) {
                int rem = x % 10;
                temp += rem * rem;
                x = x / 10;
            }
            // System.out.println("temp: "+temp);
            if (temp == 1) {
                return true;
            }
            x = temp;
        }
        return false;

    }
}
