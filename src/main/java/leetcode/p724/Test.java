package leetcode.p724;

import leetcode.p724.Solution;
import org.junit.Assert;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test2(){
        int i = new Solution().pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        Assert.assertEquals(3, i);
    }
}
