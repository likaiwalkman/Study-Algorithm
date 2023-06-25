package leetcode.p206;

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;

            newHead = head;
            head = next;
        }
        return newHead;
    }
}