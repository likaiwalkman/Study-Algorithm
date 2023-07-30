package leetcode.p86;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1,4,3,2,5,2});
        ListNode partition = new Solution().partition(listNode, 3);
        System.out.println();
    }

    @org.junit.Test
    public void test2(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1,4,3,2,5,2});
        ListNode partition = new Solution().partition(listNode, 3);
        System.out.println();
    }
}
