package leetcode.p71;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        int index = 0;
        List<String> items = new ArrayList<>();
        while (index < path.length()){
            int index0 = index;
            while (index0+1 < path.length() && path.charAt(index0+1) == '/'){
                index0++;
            }
            index = index0+1;
            index0 = index;
            StringBuilder builder = new StringBuilder();
            if (index0 < path.length() && path.charAt(index0) != '/'){
                builder.append(path.charAt(index0));
            }
            while (index0+1 < path.length() && path.charAt(index0+1) != '/') {
                builder.append(path.charAt(index0+1));
                index0++;
            }
            index = index0+1;
            if (builder.length() > 0) {
                items.add(builder.toString());
            }
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < items.size(); i++) {
            String s = items.get(i);
            if (".".equals(s)) {
                continue;
            }else if ("..".equals(s)){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(s);
            }
        }
        Stack<String> reverseStack = new Stack<>();
        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        items.clear();
        while (!reverseStack.isEmpty()) {
            items.add(reverseStack.pop());
        }
        StringBuilder builder = new StringBuilder("/");
        for (int i = 0; i < items.size(); i++) {
            if (i == items.size()-1) {
                builder.append(items.get(i));
            }else {
                builder.append(items.get(i));
                builder.append("/");
            }
        }
        System.out.println(builder);
        return builder.toString();
    }
}
