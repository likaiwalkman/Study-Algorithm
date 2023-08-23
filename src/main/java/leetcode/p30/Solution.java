package leetcode.p30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, 1 + map.get(word));
            }

        }
        int wordLen = words[0].length();
        int slidingWinSize = words.length * wordLen;

        List<Integer> result = new ArrayList<>();
        if (s.length() < slidingWinSize) {
            return result;
        }
        for (int i = 0; i <= s.length() - slidingWinSize; i++) {
            Map<String, Integer> cal = new HashMap<>();
            boolean flag = true;
            for (int j = i; j <= (words.length-1)*wordLen+i; j += wordLen) {
                String item = s.substring(j, j + wordLen);
                if (!map.containsKey(item)) {
                    flag = false;
                    break;
                }
                if (!cal.containsKey(item)) {
                    cal.put(item, 1);
                }else {
                    cal.put(item, 1+cal.get(item));
                }
            }
            if (flag && cal.equals(map)){
                result.add(i);
            }
        }
        return result;
    }
}
