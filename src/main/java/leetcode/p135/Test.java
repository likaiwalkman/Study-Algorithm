package leetcode.p135;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test01(){
        int candy = new Solution().candy(new int[]{1, 0, 2});
        Assert.assertEquals(5, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test02(){
        int candy = new Solution().candy(new int[]{1, 2, 3, 4, 5, 6, 3, 2});
        Assert.assertEquals(24, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test03(){
        int candy = new Solution().candy(new int[]{1, 2, 2});
        Assert.assertEquals(4, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test04(){
        int candy = new Solution().candy(new int[]{1, 2, 2, 2});
        Assert.assertEquals(5, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test05(){
        int candy = new Solution().candy(new int[]{1, 2, 2, 3});
        Assert.assertEquals(6, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test06(){
        int candy = new Solution().candy(new int[]{1, 2, 2, 2, 3});
        Assert.assertEquals(7, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test07(){
        int candy = new Solution().candy(new int[]{1,2,3,5,4,3,2,1});
        Assert.assertEquals(21, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test08(){
        int candy = new Solution().candy(new int[]{29,51,87,87,72,12});
        Assert.assertEquals(12, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test09(){
        int candy = new Solution().candy(new int[]{1,2,3,5,4,3,2,1,4,3,2,1,3,2,1,1,2,3,4});
        Assert.assertEquals(47, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test10(){
        int candy = new Solution().candy(new int[]{5,1,1,1,10,2,1,1,1,3});
        Assert.assertEquals(15, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test11(){
        int candy = new Solution().candy(new int[]{1,3,2,2,1});
        Assert.assertEquals(7, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test12(){
        int candy = new Solution().candy(new int[]{1,2,87,87,87,2,1});
        Assert.assertEquals(13, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test13(){
        int candy = new Solution().candy(new int[]{4,2,3,4,1});
        Assert.assertEquals(9, candy);
        System.out.println(candy);
    }

    @org.junit.Test
    public void test14(){
        int candy = new Solution().candy(new int[]{58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89});
        Assert.assertEquals(208, candy);
        System.out.println(candy);
    }
}
