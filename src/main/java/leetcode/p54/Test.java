package leetcode.p54;

import org.junit.Assert;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        List<Integer> list = new Solution().spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}
        });
        System.out.println(list);
        Assert.assertEquals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]", list.toString());
    }

    @org.junit.Test
    public void test2(){
        List<Integer> list = new Solution().spiralOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        });
        System.out.println(list);
        Assert.assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", list.toString());
    }

    @org.junit.Test
    public void test3(){
        List<Integer> list = new Solution().spiralOrder(new int[][]{
                new int[]{3},
                new int[]{2}
        });
        System.out.println(list);
        Assert.assertEquals("[3, 2]", list.toString());
    }
}
