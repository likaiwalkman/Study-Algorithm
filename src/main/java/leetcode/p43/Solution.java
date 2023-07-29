package leetcode.p43;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        List<Stack<Integer>> list = new ArrayList<>();
        int num1Len = num1.length();
        int num2Len = num2.length();

        int groupOffset = 0;
        for (int i = num1Len - 1; i >=0 ; i--) {
            int n1 = (int)(num1.charAt(i) - '0');

            Stack<Integer> stack = new Stack<>();
            for (int k = 0; k < groupOffset; k++) {
                stack.add(0);
            }
            int progess = 0;
            for (int j = num2Len - 1; j >= 0 ; j--) {
                int n2 = (int)(num2.charAt(j) - '0');
                int time = n1 * n2 + progess;
                stack.push(time % 10);
                progess = time / 10;
            }
            if (progess != 0) {
                stack.push(progess);
            }

            Stack<Integer> reverse = new Stack<>();
            while (stack.size() > 0) {
                reverse.push(stack.pop());
            }
            list.add(reverse);
            groupOffset++;
        }
        int progress = 0;

        Stack<Integer> result = new Stack<>();
        while (list.size() > 0 || progress > 0){
            int sum = 0;
            Iterator<Stack<Integer>> iterator = list.iterator();
            while (iterator.hasNext()) {
                Stack<Integer> stack = iterator.next();
                sum += stack.pop();
                if (stack.size() == 0) {
                    iterator.remove();
                }
            }
            sum += progress;

            result.add(sum % 10);
            progress = sum / 10;
        }

        StringBuilder builder = new StringBuilder();
        while (result.size() > 0) {
            builder.append(result.pop());
        }

        return builder.toString();
    }
}
