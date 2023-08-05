package leetcode.p199;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode node = MarshallUtils.marshall(new Integer[]{1,2,3,null,5,null,4});
        List<Integer> integers = new Solution().rightSideView(node);
        Assert.assertEquals("[1, 3, 4]", integers.toString());
        System.out.println(integers);
    }

    @org.junit.Test
    public void test2(){
        TreeNode node = MarshallUtils.marshall(new Integer[]{1,null,3});
        List<Integer> integers = new Solution().rightSideView(node);
        Assert.assertEquals("[1, 3]", integers.toString());
        System.out.println(integers);
    }

    @org.junit.Test
    public void test3(){
        TreeNode node = MarshallUtils.marshall(new Integer[]{23,28,null,21,null,6,19,48,8,null,null,null,null,22,31,null,null,4,36,34,30,null,null,null,null,27,2,null,null,3,26,null,null,55,null,1,null,15,41,null,null,37,39,14,51,null,null,null,null,46,null,32,12,null,null,45,9,null,null,29,10,null,null,null,18,43,25,47,50,null,7,null,null,null,null,40,44,17,null,null,null,49,null,35,20,11,54,53,5,null,null,52,33,null,null,null,16,null,null,42,38,null,null,null,null,13,24,null,null,null,null});
        List<Integer> integers = new Solution().rightSideView(node);
        Assert.assertEquals("[23, 28, 21, 8, 36, 41, 17]", integers.toString());
        System.out.println(integers);
    }
}
