package leetcode.p190;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        int i = new Solution().reverseBits(43261596);
        Assert.assertEquals(964176192, i);
    }

    @org.junit.Test
    public void test2(){
        int i = new Solution().reverseBits(1);
        System.out.println(i);
    }
    @org.junit.Test
    public void test3(){
        int x1 = 0xfffffffd;
        int x = 0xffffffff + 2;
        int i = new Solution().reverseBits(x);
        System.out.println(i);
    }

    @org.junit.Test
    public void test4(){
        int x1 = 0xfffffffd;
        int x2 = 0xffffffff;
        int x = 0x80000001;
        Integer z = new Integer(0);

        int i = new Solution().reverseBits(x1);
        System.out.println(i);
    }
}
