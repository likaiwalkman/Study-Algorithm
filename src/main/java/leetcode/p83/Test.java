package leetcode.p83;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 1, 3});
        ListNode node = new Solution().deleteDuplicates(listNode);
        System.out.println(node);
    }

    @org.junit.Test
    public void test2(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 1, 2, 3, 3});
        ListNode node = new Solution().deleteDuplicates(listNode);
        System.out.println(node);
    }
}
