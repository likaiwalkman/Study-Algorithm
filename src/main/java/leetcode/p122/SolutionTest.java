package leetcode.p122;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SolutionTest {

    @Test
    public void test01(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        new Solution().refreshBestResult(list, new int[]{1, 7, 3, 5, 4, 6}, atomicInteger);

        System.out.println(atomicInteger);
    }

    @Test
    public void test02(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        new Solution().refreshBestResult(list, new int[]{1,2,3}, atomicInteger);

        System.out.println(atomicInteger);
    }

    @Test
    public void test1(){
        int i = new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(7, i);
    }

    @Test
    public void test2(){
        int i = new Solution().maxProfit(new int[]{1,2,3,4,5});
        Assert.assertEquals(4, i);
    }

    @Test
    public void test3(){
        int i = new Solution().maxProfit(new int[]{7,6,4,3,1});
        Assert.assertEquals(0, i);
    }

    @Test
    public void test4(){
        int i = new Solution().maxProfit(new int[]{7,1,5,3,6,4});
        Assert.assertEquals(7, i);
    }
}
