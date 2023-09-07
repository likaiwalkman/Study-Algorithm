package leetcode.p2130;

import leetcode.common.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int n = 0;

        while (head != null) {
            stack.push(head.val);
            queue.offer(head.val);
            head = head.next;
            n++;
        }
        int max = 0;
        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, stack.pop()+queue.poll());
        }
        return max;
    }
}
