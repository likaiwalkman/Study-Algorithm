package leetcode.p42;

public class Test {
    @org.junit.Test
    public void test1(){
        int trap = new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

    @org.junit.Test
    public void test2(){
        int trap = new Solution().trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap);
    }
}
