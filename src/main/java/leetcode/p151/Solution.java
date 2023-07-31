package leetcode.p151;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        boolean isBlank = s.charAt(0) == ' ';
        Stack<String> stack = new Stack<>();
        boolean encounterValidString = false;
        int pos = 0;
        while (pos < s.length()) {
            int pos0 = pos;
            if (isBlank) {
                while (pos0 + 1 < s.length() && s.charAt(pos0 + 1) == ' ') {
                    pos0++;
                }
            }else {
                while (pos0 + 1 < s.length() && s.charAt(pos0 + 1) != ' ') {
                    pos0++;
                }
            }
            if (!isBlank) {
                encounterValidString = true;
            }

            if (encounterValidString) {
                String item = s.substring(pos, pos0+1);
                //System.out.println(item);
                stack.push(item);
            }
            isBlank = !isBlank;

            pos = pos0 + 1;
        }

        List<String> resultList = new ArrayList<>();
        boolean flag = false;
        while (stack.size() > 0) {
            String pop = stack.pop();
            if (pop.charAt(0) == ' ' && !flag) {
                continue;
            }
            if (pop.charAt(0) != ' ') {
                flag = true;
            }
            resultList.add(pop);
        }

        //System.out.println(resultList);
        StringBuilder builder = new StringBuilder();
        for (String item : resultList) {
            if (item.charAt(0) == ' ') {
                builder.append(' ');
            }else {
                builder.append(item);
            }
        }
        return builder.toString();
    }
}
