package leetcode.p61;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 2, 3, 4, 5});
        ListNode newListNode = new Solution().rotateRight(listNode, 2);
        System.out.println(newListNode);
    }

    @org.junit.Test
    public void test2(){
        ListNode listNode = ListNodeUtils.parse(new int[]{0,1,2});
        ListNode newListNode = new Solution().rotateRight(listNode, 4);
        System.out.println(newListNode);
    }
}
