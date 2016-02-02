package linkedlist.oddEvenLinkedList;

/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
 */

/**
 * Created by victor on 16/2/3.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null ){
            return head;
        }
        ListNode link = head.next;

        ListNode odd = head;
        ListNode even = head.next;


        ListNode node = even;
        int i = 0;
        while((node = node.next) != null){
            if (i%2 == 0){
                odd.next = node;
                odd = node;
            } else {
                even.next = node;
                even = node;
            }
            i++;
        }
        odd.next = link;
        return head;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n2.next = n3;
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        n1 = new Solution().oddEvenList(n1);
        System.out.println(n1);

    }
}
