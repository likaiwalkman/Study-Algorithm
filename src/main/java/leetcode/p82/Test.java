package leetcode.p82;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode listNode1 = new Solution().deleteDuplicates(listNode);
        System.out.println(listNode1);
    }

    @org.junit.Test
    public void test2(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 2, 2});
        ListNode listNode1 = new Solution().deleteDuplicates(listNode);
        System.out.println(listNode1);
    }
}
