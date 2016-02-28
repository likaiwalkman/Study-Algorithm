package leetcode.loop.reverseLinkedList;



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode reverseList(ListNode head) {
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
}