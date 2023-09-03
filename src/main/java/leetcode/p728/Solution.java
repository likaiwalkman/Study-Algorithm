package leetcode.p728;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (passThrough(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean passThrough(int k){
        int temp = k;
        while (k != 0) {
            int i = k % 10;
            if (i == 0) {
                return false;
            }else {
                if (temp % i != 0) {
                    return false;
                }
            }
            k = k / 10;
        }
        return true;
    }
}
