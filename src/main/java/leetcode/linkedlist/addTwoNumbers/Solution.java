package leetcode.linkedlist.addTwoNumbers;

/* You are given two linked lists representing two non-negative numbers.
   The digits are stored in reverse order and each of their nodes contain a single digit.
   Add the two numbers and return it as a linked list.

   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
   Output: 7 -> 0 -> 8
*/

/**
 * Created by victor on 16/1/30.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode node = null;
        int advance = 0;
        while (l1 != null || l2 != null || advance != 0) {
            int total = ( l1 != null ? l1.val : 0 ) + ( l2 != null ? l2.val : 0 );

            ListNode n = new ListNode((total+advance)%10);
            advance = (total+advance)/10;
            if(root == null){
                root = n;
            }
            if(node == null){
                node = n;
            } else {
                node.next = n;
                node = node.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return root;
    }

    public static void main(String[] args) {
        String haha = "";
        char[] chars = haha.toCharArray();
        ListNode node = new ListNode(1);
        ListNode l1 = node;
        ListNode l2 = new ListNode(9);
        ListNode node2 = l2;
        node2.next = new ListNode(9);
        ListNode rs = new Solution().addTwoNumbers(l1,l2);
        System.out.println(node);
    }

}