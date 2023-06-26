package leetcode.p121;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;

public class SolutionTest {

    @Test
    public void test1(){
        int i = new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(5, i);
    }

    @Test
    public void test2(){
        int i = new Solution().maxProfit(new int[]{7,6,4,3,1});
        Assert.assertEquals(0, i);
    }

    @Test
    public void test3() throws Exception{
        InputStream ins = getClass().getClassLoader().getResourceAsStream("leetcode/p121/arr.txt");
        String s = IOUtils.toString(ins);
        Object[] array = Arrays.stream(s.split(",")).map(Integer::parseInt).toArray();
        int[] ints = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            ints[i] = (int)array[i];
        }
        int i = new Solution().maxProfit(ints);
        Assert.assertEquals(999, i);
    }
}
