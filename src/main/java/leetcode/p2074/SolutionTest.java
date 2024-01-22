package leetcode.p2074;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        ListNode original = ListNodeUtils.parse(new int[]{1});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println();
    }

    @Test
    public void test2(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println();
    }

    @Test
    public void test3(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println();
    }

    @Test
    public void test4(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3,4});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println();
    }

    @Test
    public void test5(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3,4,5});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println();
    }
}
