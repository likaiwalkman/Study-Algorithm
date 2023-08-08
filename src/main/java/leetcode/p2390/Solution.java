package leetcode.p2390;

import java.util.Stack;

public class Solution {
    public String removeStars(String s) {
        Stack<Character> raw = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            raw.push(s.charAt(i));
        }
        int startCount = 0;
        Stack<Character> resultStack = new Stack<>();
        while (!raw.isEmpty()){
            Character c = raw.pop();

            if (c == '*') {
                startCount++;
            }else {
                if (startCount > 0){
                    startCount--;
                }else {
                    resultStack.push(c);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!resultStack.isEmpty()) {
            builder.append(resultStack.pop());
        }
        return builder.toString();
    }
}
