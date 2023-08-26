package leetcode.p25;

import leetcode.common.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        ListNode prevSeqEnd = null;
        ListNode newHead = null;


        while (head != null){
            int count = 1;
            ListNode seqStart = head;
            while (head.next != null && count != k) {
                head = head.next;
                count++;
            }
            ListNode seqEnd = head;
            head = seqEnd.next;
            seqEnd.next = null;

            if (count == k){
                ListNode cursor = seqStart;
                ListNode next = null;
                ListNode cursor0 = null;
                while (cursor != seqEnd) {
                    cursor0 = cursor;
                    cursor = cursor.next;
                    cursor0.next = next;
                    next = cursor0;
                }
                seqEnd.next = cursor0;
                ListNode tmp = seqStart;
                seqStart = seqEnd;
                seqEnd = tmp;
            }

            if (newHead == null){
                newHead = seqStart;
            }

            if (prevSeqEnd != null){
                prevSeqEnd.next = seqStart;
            }
            prevSeqEnd = seqEnd;
        }

        return newHead;
    }
}
