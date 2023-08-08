package leetcode.p2095;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        ListNode parse = ListNodeUtils.parse(new int[]{1, 3, 4, 7, 1, 2, 6});
        ListNode listNode = new Solution().deleteMiddle(parse);
        System.out.println(listNode);
    }
}
