package leetcode.p160;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aCount = 0;
        int bCount = 0;
        ListNode headATail = null;
        ListNode headBTail = null;

        ListNode a = headA;
        while ( a != null ){
            aCount++;
            if (a.next == null) {
                headATail = a;
            }
            a = a.next;
        }

        ListNode b = headB;
        while ( b != null ){
            bCount++;
            if (b.next == null) {
                headBTail = b;
            }
            b = b.next;
        }

        if (headATail != headBTail){
            return null;
        }

        ListNode longer = aCount > bCount ? headA : headB;
        ListNode shorter = aCount > bCount ? headB : headA;

        int diff = aCount - bCount;
        diff = diff > 0 ? diff : -diff;

        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }

        while (longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }
}
