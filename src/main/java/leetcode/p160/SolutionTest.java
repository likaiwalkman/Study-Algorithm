package leetcode.p160;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;

        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        l6.next = l7;

        l2.next = l6;
        l5.next = l6;


        ListNode intersectionNode = new Solution().getIntersectionNode(l1, l3);
        System.out.println(intersectionNode);
    }
}
