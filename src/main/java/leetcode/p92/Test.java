package leetcode.p92;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 2, 3, 4, 5});
        ListNode res = new Solution().reverseBetween(listNode, 2, 4);
        System.out.println(res);
    }

    @org.junit.Test
    public void test2(){
        ListNode listNode = ListNodeUtils.parse(new int[]{5});
        ListNode res = new Solution().reverseBetween(listNode, 1, 1);
        System.out.println(res);
    }

    @org.junit.Test
    public void test3(){
        ListNode listNode = ListNodeUtils.parse(new int[]{3,5});
        ListNode res = new Solution().reverseBetween(listNode, 1, 2);
        System.out.println(res);
    }
}
