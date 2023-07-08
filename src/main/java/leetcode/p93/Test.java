package leetcode.p93;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        List<String> strings = new Solution().restoreIpAddresses("0000");
        System.out.println(strings);
    }

    @org.junit.Test
    public void test2(){
        List<String> strings = new Solution().restoreIpAddresses("25525511135");
        System.out.println(strings);
    }

    @org.junit.Test
    public void test3(){
        List<String> strings = new Solution().restoreIpAddresses("101023");
        System.out.println(strings);
    }

    @org.junit.Test
    public void test4(){
        List<String> strings = new Solution().restoreIpAddresses("0");
        System.out.println(strings);
    }
}
