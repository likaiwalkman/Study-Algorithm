package leetcode.p92;

import leetcode.common.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right){
            return head;
        }

        ListNode head0 = head;
        ListNode aPrev = null;
        ListNode cNext = null;

        int steps = 1;
        while (steps != left) {
            aPrev = head;
            head = head.next;
            steps++;
        }

        ListNode aNode = head;
        ListNode cNode = null;
        int distance = 0;

        ListNode headNext = head.next;
        ListNode headNextNext = head.next.next;

        while (distance < right - left) {

            headNext.next = head;
            ListNode nextLoopHeadNextNext = null;
            if(headNextNext != null){
                nextLoopHeadNextNext = headNextNext.next;
            };

            cNode = headNext;
            cNext = headNextNext;

            head = headNext;
            headNext = headNextNext;
            headNextNext = nextLoopHeadNextNext;

            distance++;
        }

        aNode.next = cNext;
        if (aPrev!=null) {
            aPrev.next = cNode;
        }
        if (aPrev == null){
            return cNode;
        }else {
            return head0;
        }
    }
}
