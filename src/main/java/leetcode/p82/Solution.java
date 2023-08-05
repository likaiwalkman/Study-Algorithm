package leetcode.p82;

import leetcode.common.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode newHead = null;
        ListNode tail = null;
        while (head != null) {
            ListNode head0 = head;
            while (head.next != null && head.val == head.next.val){
                head = head.next;
            }
            if (head != head0){
                head = head.next;
                continue;
            }

            if (newHead == null){
                newHead = head;
            }
            if (tail == null) {
                tail = head;
            }else {
                tail.next = head;
                tail = head;
            }
            head = head.next;
        }
        if (tail != null){
            tail.next = null;
        }
        return newHead;
    }
}
