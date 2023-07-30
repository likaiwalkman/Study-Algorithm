package leetcode.p80;

public class Test {
    @org.junit.Test
    public void test1(){
        int[] ints = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int i = new Solution().removeDuplicates(ints);
        System.out.println(i);
    }
}
