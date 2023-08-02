package leetcode.p190;

import java.util.Stack;

public class Solution {
    public int reverseBits(int n) {
        if (n == 0 || n == -1){
            return n;
        }
        Stack<Integer> stack = toStack(n);
        Stack<Integer> reverse = reverse(stack);
        int newInt = 0;
        while (reverse.size() > 0) {
            newInt = newInt << 1;
            newInt = reverse.pop() | newInt;
        }
        return newInt;
    }

    public static Stack<Integer> reverse(Stack<Integer> stack){
        Stack<Integer> result = new Stack<>();
        while (stack.size() > 0) {
            result.push(stack.pop());
        }
        return result;
    }

    public static Stack<Integer> toStack(int n){
        int digits = 32;
        Stack<Integer> stack = new Stack<>();
        while (digits > 0){
            stack.push(n % 2 == 0 ? 0 : 1);
            n = n >>> 1;
            digits--;
        }
        return stack;
    }
}
