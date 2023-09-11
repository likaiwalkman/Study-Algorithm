package leetcode.p237;

import leetcode.common.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        ListNode nextNext = node.next.next;

        while (nextNext != null) {
          node.val = next.val;

          node = next;
          next = nextNext;
          nextNext = nextNext.next;
        }

        node.val = next.val;
        node.next = null;
    }
}
