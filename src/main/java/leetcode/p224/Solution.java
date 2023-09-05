package leetcode.p224;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);


        int n = s.length();
        int i = 0;
        int result = 0;
        int sign = 1;

        while (i < n){
            char c = s.charAt(i);
            switch (c){
                case '+':
                    sign = stack.peek();
                    i++;
                    break;
                case '-':
                    sign = -stack.peek();
                    i++;
                    break;
                case '(':
                    stack.push(sign);
                    i++;
                    break;
                case ')':
                    stack.pop();
                    sign = stack.peek();
                    i++;
                    break;
                case ' ':
                    i++;
                    break;
                default:
                    int num = 0;
                    while (i < n && 0 <= (s.charAt(i)-'0') && (s.charAt(i)-'0') <=9){
                        num = num * 10 + (s.charAt(i)-'0');
                        i++;
                    }
                    result += sign * num;
                    break;
                }
            }
        return result;
    }
}
