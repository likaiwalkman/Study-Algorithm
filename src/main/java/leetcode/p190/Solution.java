package leetcode.p190;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(1<<30);
        int x = 0xffffffff + 2;
    }
    public int reverseBits(int n) {
        int digits = 32;

        if (n == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        while (digits > 0){
            stack.push(n % 2 == 0 ? 0 : 1);
            n = n >> 1;
            digits--;
        }
        Stack<Integer> reverseStack = new Stack<>();
        while (stack.size() > 0) {
            reverseStack.push(stack.pop());
        }
        int newInt = 0;
        while (reverseStack.size() > 0) {
            newInt = newInt << 1;
            Integer pop = reverseStack.pop();
            if (newInt >= 0){
                newInt += pop;
            }else {
                newInt -= pop;
            }
        }

        return newInt;
    }
}
