package leetcode.p98;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{2, 1, 3});
        boolean validBST = new Solution().isValidBST(treeNode);
        Assert.assertTrue(validBST);
    }

    @org.junit.Test
    public void test2(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{5,1,4,null,null,3,6});
        boolean validBST = new Solution().isValidBST(treeNode);
        Assert.assertFalse(validBST);
    }

}
