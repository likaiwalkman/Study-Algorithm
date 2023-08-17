package leetcode.p236;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode root = MarshallUtils.marshall(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode treeNode = new Solution().lowestCommonAncestor(root, p, q);
        Assert.assertEquals(3, treeNode.val);
    }

    @org.junit.Test
    public void test2(){
        TreeNode root = MarshallUtils.marshall(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        TreeNode treeNode = new Solution().lowestCommonAncestor(root, p, q);
        Assert.assertEquals(5, treeNode.val);
    }

    @org.junit.Test
    public void test3(){
        TreeNode root = MarshallUtils.marshall(new Integer[]{1,2});
        TreeNode p = root;
        TreeNode q = root.left;
        TreeNode treeNode = new Solution().lowestCommonAncestor(root, p, q);
        Assert.assertEquals(1, treeNode.val);
    }
}
