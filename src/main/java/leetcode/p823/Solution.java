package leetcode.p823;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numFactoredBinaryTrees(int[] arr) {
        int module = 1;
        for (int i = 0; i < 9; i++) {
            module *= 10;
        }
        module += 7;

        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], (long)1);
        }
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            long count = 0;
            for (int j = 0; j <= i - 1; j++) {
                int prev = arr[j];
                if (cur % prev == 0 && map.containsKey(cur/prev)) {
                    long multi = map.get(prev) * map.get(cur/prev);
                    count += multi;
                }
            }
            map.put(cur, map.get(cur)+count);
        }
        long result = 0;
        for (long value : map.values()) {
            result += value;
            result = result % module;
        }
        return (int)result;
    }

}
