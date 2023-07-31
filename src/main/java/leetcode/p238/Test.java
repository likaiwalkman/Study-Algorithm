package leetcode.p238;

public class Test {
    @org.junit.Test
    public void test1(){
        int[] ints = new Solution().productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(ints);
    }

    @org.junit.Test
    public void test2(){
        int[] ints = new Solution().productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println(ints);
    }
}
