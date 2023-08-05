package leetcode.loop.reverseLinkedList;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;

public class Test {
    @org.junit.Test
    public void test1(){
        ListNode node = ListNodeUtils.parse(new int[]{1, 2, 3, 4, 5});
        ListNode reverse = new Solution().reverse(node);
        System.out.println(reverse);
    }
}
