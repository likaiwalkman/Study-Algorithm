package leetcode.p86;

import leetcode.common.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return head;
        }
        ListNode ltHead0 = null;
        ListNode gtOrEqHead0 = null;

        ListNode ltHeadVar = null;
        ListNode gtOrEqHeadVar = null;

        while (head != null) {
            if (head.val < x) {
                if (ltHead0 == null) {
                    ltHead0 = head;
                    ltHeadVar = head;
                }else {
                    ltHeadVar.next = head;
                    ltHeadVar = head;
                }
            }else {
                if (gtOrEqHead0 == null) {
                    gtOrEqHead0 = head;
                    gtOrEqHeadVar = head;
                }else {
                    gtOrEqHeadVar.next = head;
                    gtOrEqHeadVar = head;
                }

            }
            head = head.next;
        }

        if (gtOrEqHeadVar != null){
            gtOrEqHeadVar.next = null;
        }

        ListNode newHead = null;
        if (ltHead0 != null){
            newHead = ltHead0;
            if (gtOrEqHead0 != null){
                ltHeadVar.next = gtOrEqHead0;
            }
        }else {
            newHead = gtOrEqHead0;
        }
        return newHead;
    }
}
