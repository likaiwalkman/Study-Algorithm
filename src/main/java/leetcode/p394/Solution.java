package leetcode.p394;

import skiplist.SkipList;

import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.concurrent.ConcurrentSkipListMap;

public class Solution {
    public String decodeString(String s) {
        int n = s.length();
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < n){
            char c = s.charAt(i);
            if (c == '['){
                stack.push(""+c);
                i++;
            } else if(c==']'){
                Stack<String> item = new Stack<>();
                while (!"[".equals(stack.peek())){
                    item.push(stack.pop());
                }
                stack.pop();
                StringBuilder builder = new StringBuilder();
                while (!item.isEmpty()) {
                    builder.append(item.pop());
                }
                int count = Integer.parseInt(stack.pop());
                String string = builder.toString();
                for (int k = 1; k < count; k++) {
                    builder.append(string);
                }
                stack.push(builder.toString());

                i++;
            } else if('0' <= c && c <= '9'){
                int num = 0;
                while (i < n && '0' <= s.charAt(i) && s.charAt(i) <= '9'){
                    num = num * 10 + (s.charAt(i)-'0');
                    i++;
                }
                stack.push(""+num);
            }else {
                stack.push(""+c);
                i++;
            }
        }

        Stack<String> item = new Stack<>();
        while (!stack.isEmpty()){
            item.push(stack.pop());
        }
        StringBuilder builder = new StringBuilder();
        while (!item.isEmpty()) {
            builder.append(item.pop());
        }
        return builder.toString();
    }
}
