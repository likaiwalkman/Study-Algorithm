package leetcode.p89;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        List<Integer> integers = new Solution().grayCode(2);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    @org.junit.Test
    public void test2(){
        List<Integer> integers = new Solution().grayCode(1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    @org.junit.Test
    public void test3(){
        List<Integer> integers = new Solution().grayCode(3);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
