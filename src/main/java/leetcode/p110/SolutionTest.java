package leetcode.p110;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{3, 9, 20, null, null, 15, 7});
        boolean balanced = new Solution().isBalanced(treeNode);
        Assert.assertTrue(balanced);
    }

    @org.junit.Test
    public void test2(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{1,2,2,3,3,null,null,4,4});
        boolean balanced = new Solution().isBalanced(treeNode);
        Assert.assertFalse(balanced);
    }

    @org.junit.Test
    public void test3(){
        TreeNode treeNode = null;
        boolean balanced = new Solution().isBalanced(treeNode);
        Assert.assertTrue(balanced);
    }
}
