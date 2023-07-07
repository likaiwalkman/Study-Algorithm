package leetcode.p24;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        ListNode listNode = ListNodeUtils.parse(new int[]{1, 2, 3, 4});
        System.out.println(listNode);

        ListNode swappedPairs = new Solution().swapPairs(listNode);
        System.out.println(swappedPairs);
    }
}
