package leetcode.p2074;

import leetcode.common.ListNode;

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null) {
            return head;
        }
        final ListNode HEAD = head;

        int groupLen=1;
        ListNode prevGroupTail = null;
        ListNode nextGroupHead = null;


        while (head != null ){
            ListNode groupHead = head;
            ListNode groupTail = null;
            int count = 0;
            while (head != null && count < groupLen){
                groupTail = head;
                head = head.next;
                count++;
            }
            nextGroupHead = head;

            if (count % 2 == 0){
                ListNode oldGroupHead = groupHead;
                while (groupHead.next != groupTail) {
                    ListNode next = groupHead.next;
                    next.next = groupHead;
                    groupHead = next;
                }
                groupTail.next = groupHead;

                oldGroupHead.next = nextGroupHead;

                groupTail.next=groupHead;
                if (prevGroupTail != null){
                    prevGroupTail.next = groupTail;
                }

                prevGroupTail = oldGroupHead;
            }else {
                prevGroupTail = groupTail;
            }


            groupLen++;
        }

        return HEAD;
    }
}