package leetcode.p2;


import org.junit.Test;

public class SolutionTest {

    ListNode build(int[] ints){
        ListNode head = null;
        ListNode iterator = null;

        for (int i : ints) {
            ListNode listNode = new ListNode(i);

            if (head == null) {
                head = listNode;
            }

            if (iterator != null) {
                iterator.next = listNode;
            }

            iterator = listNode;
        }
        return head;
    }

    @Test
    public void test04(){
        ListNode l1 = build(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = build(new int[]{9, 9, 9});

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    @Test
    public void test05(){
        ListNode l1 = build(new int[]{9});
        ListNode l2 = build(new int[]{1,9,9,9,9,9,9,9,9,9});

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

}
