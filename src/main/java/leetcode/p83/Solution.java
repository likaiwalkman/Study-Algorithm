package leetcode.p83;

import leetcode.common.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode originalHead = head;

        while (head != null){
            if (head.next != null) {
                if (head.next.val == head.val) {
                    head.next = head.next.next;
                }else {
                    head = head.next;
                }
            }else {
                head = head.next;
            }
        }


        return originalHead;
    }
}
