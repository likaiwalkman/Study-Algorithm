package leetcode.p19;

import leetcode.common.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head0 = head;
        int total = 0;
        while (head != null){
            head = head.next;
            total++;
        }
        int targetIndexZeroBased = total - n ;
        ListNode targetPrev = null;
        ListNode targetNext = null;
        ListNode target = null;

        int index = -1;
        head = head0;
        while (head != null){
            index++;

            if (index == targetIndexZeroBased) {
                target = head;
                targetNext = head.next;
                break;
            }else {
                targetPrev = head;
            }

            head = head.next;
        }

        if (targetPrev != null) {
            targetPrev.next = targetNext;
            return head0;
        }else {
            target.next = null;
            return targetNext;
        }
    }
}
