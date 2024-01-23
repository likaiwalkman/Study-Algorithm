package leetcode.p2074;

import leetcode.common.ListNode;
import leetcode.common.ListNodeUtils;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        ListNode original = ListNodeUtils.parse(new int[]{1});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }

    @Test
    public void test2(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }

    @Test
    public void test3(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }

    @Test
    public void test4(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3,4});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }

    @Test
    public void test5(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3,4,5});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }

    @Test
    public void test6(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3,4,5,6});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }

    @Test
    public void test7(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3,4,5,6,7});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }

    @Test
    public void test9(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3,4,5,6,7,8,9});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }



    @Test
    public void test10(){
        ListNode original = ListNodeUtils.parse(new int[]{1,2,3,4,5,6,7,8,9,10});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }

    @Test
    public void test11(){
        ListNode original = ListNodeUtils.parse(new int[]{5,2,6,3,9,1,7,3,8,4});
        ListNode listNode = new Solution().reverseEvenLengthGroups(original);
        System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
    }

    @Test
    public void testGeneral(){
        int maxLen = 20;
        for (int i = 1; i <= maxLen; i++) {
            int[] ints = new int[i];
            for (int j = 0; j < i; j++) {
                ints[j] = j+1;
            }
            ListNode original = ListNodeUtils.parse(ints);
            ListNode listNode = new Solution().reverseEvenLengthGroups(original);
            System.out.println(ListNodeUtils.convertNonCyclicListNodeToString(listNode));
        }
    }

}
