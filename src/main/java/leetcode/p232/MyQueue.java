package leetcode.p232;

import java.util.Stack;

class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack1.size() == 0) {
            return 0;
        }
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        Integer pop = stack2.pop();
        while (stack2.size() > 0) {
            int k = stack2.pop();
            stack1.push(k);
        }
        return pop;
    }

    public int peek() {
        if (stack1.size() == 0) {
            return 0;
        }
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        Integer pop = stack2.peek();
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        return pop;
    }

    public boolean empty() {
        return stack1.empty();
    }
}
