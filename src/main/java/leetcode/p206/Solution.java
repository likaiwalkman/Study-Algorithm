package leetcode.p206;

import leetcode.common.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode newHead = null;
        while (head != null){
            ListNode nextHead = head.next;

            ListNode oldHead = newHead;
            head.next = oldHead;
            newHead = head;

            head = nextHead;
        }
        return newHead;
    }
}
