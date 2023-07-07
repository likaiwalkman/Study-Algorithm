package leetcode.p88;

public class Test {
    @org.junit.Test
    public void test1(){
        int[] ints = {1, 2, 3, 0, 0, 0};
        new Solution().merge(ints, 3, new int[]{2,5,6}, 3);
        System.out.println(ints);
    }

    @org.junit.Test
    public void test2(){
        int[] ints = {0};
        new Solution().merge(ints, 0, new int[]{1}, 1);
        System.out.println(ints);
    }
}
