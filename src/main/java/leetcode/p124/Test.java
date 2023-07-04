package leetcode.p124;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        int i = new Solution().maxPathSum(t1);
        Assert.assertEquals(6, i);
    }

    @org.junit.Test
    public void test2(){
        TreeNode t1 = new TreeNode(-3);
        int i = new Solution().maxPathSum(t1);
        Assert.assertEquals(-3, i);
    }

    @org.junit.Test
    public void test3(){
        TreeNode t1 = new TreeNode(-3);
        int i = new Solution().maxPathSum(t1);
        Assert.assertEquals(-3, i);
    }

    @org.junit.Test
    public void test4(){
        leetcode.common.TreeNode root = MarshallUtils.marshall(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        System.out.println(root);
        int result = new Solution().maxPathSum(root);
        Assert.assertEquals(49, result);
    }

    @org.junit.Test
    public void test5(){
        leetcode.common.TreeNode root = MarshallUtils.marshall(new Integer[]{-1,8,2,null,-9,0,null,null,null,-3,null,null,-9,null,2});
        System.out.println(root);
        int result = new Solution().maxPathSum(root);
        Assert.assertEquals(9, result);
    }
}
