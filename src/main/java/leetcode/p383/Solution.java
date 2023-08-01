package leetcode.p383;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        Map<Character, Integer> characterCounter = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!characterCounter.containsKey(c)) {
                characterCounter.put(c, 1);
            }else {
                characterCounter.put(c, characterCounter.get(c)+1);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (characterCounter.containsKey(c)) {
                Integer count = characterCounter.get(c);
                if (count == 1) {
                    characterCounter.remove(c);
                }else {
                    characterCounter.put(c, count-1);
                }
            }
        }

        return characterCounter.size() == 0;
    }
}
