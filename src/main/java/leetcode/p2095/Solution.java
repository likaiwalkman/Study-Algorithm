package leetcode.p2095;

import leetcode.common.ListNode;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int len = length(head);
        int half = len / 2;
        ListNode head0 = head;

        if (half == 0){
            head0.next = null;
            head = head.next;
            return head;
        }

        ListNode delNodePrev = null;
        ListNode delNode = null;
        ListNode delNodeNext = null;
        int count = 0;
        while (head != null){
            if (half-1 == count){
                delNodePrev = head;
            }
            if (half == count){
                delNode = head;
            }
            if (half+1 == count){
                delNodeNext = head;
            }
            head = head.next;
            count++;
        }

        delNodePrev.next=delNodeNext;
        delNode.next=null;
        return head0;
    }

    private int length(ListNode head){
        int n = 0;
        while (head != null){
            n++;
            head = head.next;
        }
        return n;
    }
}
