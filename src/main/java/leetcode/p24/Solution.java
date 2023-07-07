package leetcode.p24;

import leetcode.common.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode newHead = null;
        ListNode prevHead = null;
        while (head != null && head.next != null) {
            ListNode a = head;
            ListNode b = head.next;
            ListNode c = head.next.next;

            a.next = c;
            b.next = a;

            if (newHead == null) {
                newHead = b;
            }

            if (prevHead != null) {
                prevHead.next = b;
            }
            prevHead = a;


            head = c;
        }

        return newHead == null ? head : newHead;
    }
}
