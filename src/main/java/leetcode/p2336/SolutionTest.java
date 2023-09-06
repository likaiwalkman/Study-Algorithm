package leetcode.p2336;

import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();

        Assert.assertEquals(1, smallestInfiniteSet.popSmallest());
        Assert.assertEquals(2, smallestInfiniteSet.popSmallest());
        Assert.assertEquals(3, smallestInfiniteSet.popSmallest());
        Assert.assertEquals(4, smallestInfiniteSet.popSmallest());
        Assert.assertEquals(5, smallestInfiniteSet.popSmallest());

        smallestInfiniteSet.addBack(2);
        Assert.assertEquals(2, smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(4);
    }
}
