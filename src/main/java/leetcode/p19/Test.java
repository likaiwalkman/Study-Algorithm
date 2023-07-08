package leetcode.p19;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 2, 3, 4, 5});
        ListNode res = new Solution().removeNthFromEnd(listNode, 2);
        System.out.println(res);
    }

    @org.junit.Test
    public void test2(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1});
        ListNode res = new Solution().removeNthFromEnd(listNode, 1);
        System.out.println(res);
    }

    @org.junit.Test
    public void test3(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 2});
        ListNode res = new Solution().removeNthFromEnd(listNode, 1);
        System.out.println(res);
    }
}
