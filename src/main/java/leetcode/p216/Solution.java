package leetcode.p216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int a = 1;
        int b = 9;
        int min = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            min += a;
            max += b;
            a++;
            b--;
        }
        if (n < min || n > max){
            return result;
        }

        backtrace(result, new ArrayList<>(), 0, k, n);
        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> item, int sum, int k, int n){
        if (item.size() == k) {
            if (sum == n){
                result.add(new ArrayList<>(item));
            }
            return;
        }
        int init = 0;
        if (!item.isEmpty()) {
            init = item.get(item.size()-1);
        }
        for (int i = init+1; i <= 9; i++) {
            sum += i;
            item.add(i);
            backtrace(result, item, sum, k, n);
            item.remove(item.size()-1);
            sum -= i;
        }
    }
}
