package leetcode.p735;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> seedStack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            seedStack.push(asteroids[i]);
        }
        Stack<Integer> forwardStack = new Stack<>();
        Stack<Integer> reverseStack = new Stack<>();
        while (!seedStack.isEmpty()) {
            Integer star = seedStack.pop();
            if (star < 0){
                reverseStack.push(star);
                continue;
            }
            if (reverseStack.isEmpty()){
                forwardStack.push(star);
            }else {
                Integer peek = reverseStack.peek();
                if (star + peek == 0) {
                    reverseStack.pop();
                }else if (star + peek > 0){
                    reverseStack.pop();
                    seedStack.push(star);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!reverseStack.isEmpty()) {
            list.add(reverseStack.pop());
        }
        while (!forwardStack.isEmpty()) {
            list.add(forwardStack.pop());
        }
        if (list.size() == 0) {
            return new int[0];
        }else {
            int[] ints = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ints[i] = list.get(i);
            }
            return ints;
        }
    }
}
