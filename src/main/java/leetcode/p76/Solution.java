package leetcode.p76;

import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> readableMap = new HashMap<>();
        Map<Character, Integer> writableMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            readableMap.put(c, 0);
            if (!writableMap.containsKey(c)) {
                writableMap.put(c, 1);
            }else {
                writableMap.put(c, 1 + writableMap.get(c));
            }
        }

        Map<Character, Integer> redundants = new HashMap<>();
        LinkedList<Integer> substringIndices = new LinkedList<>();
        Integer minLen = Integer.MAX_VALUE;

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!readableMap.containsKey(c)) {
                continue;
            }

            if (writableMap.containsKey(c)) {
                substringIndices.add(i);
                if (writableMap.get(c) == 1) {
                    writableMap.remove(c);
                    if (writableMap.size() == 0) {
                        minLen = substringIndices.getLast() - substringIndices.getFirst() + 1;
                        Integer last = substringIndices.getLast();
                        Integer first = substringIndices.getFirst();
                        result = s.substring(first, last+1);
                    }
                }else {
                    writableMap.put(c, writableMap.get(c)-1);
                }
                continue;
            }
            if (readableMap.containsKey(c)){

                if (!redundants.containsKey(c)) {
                    redundants.put(c, 1);
                }else {
                    redundants.put(c, 1+redundants.get(c));
                }
                substringIndices.add(i);
                while (!redundants.isEmpty() && redundants.containsKey(s.charAt(substringIndices.getFirst()))){
                    Character toDeleteRedundant = s.charAt(substringIndices.getFirst());
                    if (redundants.get(toDeleteRedundant) == 1) {
                        redundants.remove(toDeleteRedundant);
                    }else {
                        redundants.put(toDeleteRedundant, redundants.get(toDeleteRedundant)-1);
                    }
                    substringIndices.removeFirst();
                }
                if (writableMap.isEmpty()){
                    int len = substringIndices.getLast() - substringIndices.getFirst() + 1;
                    if (len < minLen) {
                        minLen = len;
                        Integer last = substringIndices.getLast();
                        Integer first = substringIndices.getFirst();
                        result = s.substring(first, last+1);
                    }
                }
            }
        }
        return result;
    }
}
