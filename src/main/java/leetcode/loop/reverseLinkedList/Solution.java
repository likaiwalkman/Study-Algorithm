package leetcode.loop.reverseLinkedList;



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode reverseList2(ListNode head) {
        if(head==null){
            return null;
        } else {
            ListNode node = null;
            node = new ListNode(head.val);
            while((head=head.next)!=null){
                ListNode temp = new ListNode(head.val);
                temp.next = node;
                node = temp;
            }
            return node;
        }
    }

    public leetcode.common.ListNode reverse(leetcode.common.ListNode head){
        if (head == null){
            return null;
        }

        leetcode.common.ListNode newHead = null;

        while (head != null){
            leetcode.common.ListNode nextHead = head.next;

            leetcode.common.ListNode oldHead = newHead;
            head.next = oldHead;
            newHead = head;

            head = nextHead;
        }
        return newHead;
    }
}