package leetcode.p25;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class SolutionTest {

    @org.junit.Test
    public void test1(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 2, 3, 4, 5});
        ListNode result = new Solution().reverseKGroup(listNode, 2);
        System.out.println(result);
    }

    @org.junit.Test
    public void test2(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 2, 3, 4, 5});
        ListNode result = new Solution().reverseKGroup(listNode, 3);
        System.out.println(result);
    }

}
