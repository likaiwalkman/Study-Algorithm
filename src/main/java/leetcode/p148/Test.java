package leetcode.p148;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test2(){
        ListNode listNode = ListNodeUtils.parse(new int[]{-1, 5, 3, 4, 0});
        ListNode listNode1 = new Solution().sortList(listNode);
        System.out.println(listNode1);
    }
}
