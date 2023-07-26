package leetcode.p141;

import leetcode.common.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null){
            return false;
        }

        do{
            slow = slow.next;
            if (slow == null){
                return false;
            }
            fast = fast.next;
            if (fast == null){
                return false;
            }
            fast = fast.next;
            if (fast == null){
                return false;
            }
        }while (fast != slow);
        return true;
    }
}
