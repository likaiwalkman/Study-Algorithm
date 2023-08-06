package leetcode.p139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] result = new boolean[s.length()+1];
        result[0] = true;
        Set<String> wordDictSet = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] && wordDictSet.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }
}
