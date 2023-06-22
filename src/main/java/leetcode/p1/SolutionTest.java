package leetcode.p1;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class SolutionTest {
    @Test
    public void test01(){
        int[] ints = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(1, ints[1]);
    }

    @Test
    public void test02(){
        int[] ints = new Solution().twoSum(new int[]{3,2,4}, 6);
        Assert.assertEquals(1, ints[0]);
        Assert.assertEquals(2, ints[1]);
    }

    @Test
    public void test03(){
        int[] ints = new Solution().twoSum(new int[]{3,3}, 6);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(1, ints[1]);
    }

    @Test
    public void test04() throws Exception{
        InputStream stream = getClass().getClassLoader().getResourceAsStream("leetcode/p1/arr.txt");
        String s = IOUtils.toString(stream);
        String[] split = s.split(",");
        int[] input = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            int j = Integer.parseInt(split[i]);
            input[i] = j;
        }
        int[] ints = new Solution().twoSum(input, 19999);
        Assert.assertEquals(9998, ints[0]);
        Assert.assertEquals(9999, ints[1]);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }


}
