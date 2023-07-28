package leetcode.p61;

import leetcode.common.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode listNode0 = head;
        int size = 0;
        while (listNode0!=null){
            stack.add(listNode0);
            listNode0 = listNode0.next;
            size++;
        }
        k = k % size;
        if (k == 0){
            return head;
        }

        while (k > 0){
            ListNode last = stack.pop();
            if(stack.size() > 0){
                stack.peek().next = null;
            }
            last.next = head;
            head = last;
            k--;
        }

        return head;
    }
}
