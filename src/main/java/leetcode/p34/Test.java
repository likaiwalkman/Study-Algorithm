package leetcode.p34;

public class Test {
    @org.junit.Test
    public void test1(){
        int[] ints = new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(ints);
    }

    @org.junit.Test
    public void test2(){
        int[] ints = new Solution().searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.println(ints);
    }
}
