package leetcode.p2;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode iter = null;
        int contribute = 0;

        while (l1 != null || l2 != null || contribute > 0){
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            int num = (l1Val + l2Val + contribute) % 10;
            contribute = (l1Val + l2Val + contribute) / 10;
            ListNode listNode = new ListNode(num);

            if (head == null) {
                head = listNode;
            }
            if (iter != null) {
                iter.next = listNode;
            }
            iter = listNode;
        }
        return head;
    }
}
