package leetcode.p67;

import java.util.Stack;

public class Solution {
    public String addBinary(String a, String b) {
        Stack<Character> aStack = new Stack<>();
        Stack<Character> bStack = new Stack<>();
        for (char c : a.toCharArray()) {
            aStack.push(c);
        }
        for (char c : b.toCharArray()) {
            bStack.push(c);
        }

        Stack<Character> result = new Stack<>();
        int res = 0;
        while (aStack.size() > 0 || bStack.size() > 0 || res > 0){
            int item = 0;
            if (aStack.size() > 0) {
                if (aStack.pop() == '1') {
                    item++;
                }
            }
            if (bStack.size() > 0) {
                if (bStack.pop() == '1') {
                    item++;
                }
            }
            if (res == 1) {
                item++;
            }

            if (item < 2) {
                res = 0;
            }else {
                res = 1;
            }
            result.push(item % 2 == 0 ? '0' : '1');
        }
        StringBuilder builder = new StringBuilder();

        while (result.size() > 0){
            builder.append(result.pop());
        }

        String s = builder.toString();
        return s;
    }
}
