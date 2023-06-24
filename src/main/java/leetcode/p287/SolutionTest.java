package leetcode.p287;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        int duplicate = new Solution().findDuplicate(new int[]{1, 2, 2, 3, 4});
        Assert.assertEquals(2, duplicate);
    }

    @Test
    public void test2(){
        int duplicate = new Solution().findDuplicate(new int[]{1,3,4,2,2});
        Assert.assertEquals(2, duplicate);
    }

    @Test
    public void test3(){
        int duplicate = new Solution().findDuplicate(new int[]{3,1,3,4,2});
        Assert.assertEquals(3, duplicate);
    }

    @Test
    public void test4(){
        int duplicate = new Solution().findDuplicate(new int[]{2,2,2,2,2});
        Assert.assertEquals(2, duplicate);
    }
}
