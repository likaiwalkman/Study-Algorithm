package leetcode.p120;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test01(){
        List<List<Integer>> list = Arrays.asList(Arrays.asList(-10));
        int i = new Solution().minimumTotal(list);
        Assert.assertEquals(-10, i);
    }

    @org.junit.Test
    public void test02(){
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        int i = new Solution().minimumTotal(list);
        Assert.assertEquals(11, i);
    }

    @org.junit.Test
    public void test03(){
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2, 3)
        );
        int i = new Solution().minimumTotal(list);
        Assert.assertEquals(3, i);
    }
}
