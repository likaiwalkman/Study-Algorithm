package leetcode.p112;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        boolean b = new Solution().hasPathSum(treeNode, 22);
        Assert.assertTrue(b);
    }
}
