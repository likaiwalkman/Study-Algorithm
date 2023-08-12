package leetcode.p1448;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1() {
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{3,1,4,3,null,1,5});
        int i = new Solution().goodNodes(treeNode);
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test2() {
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{3, 3, null, 4, 2});
        int i = new Solution().goodNodes(treeNode);
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test3() {
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{1});
        int i = new Solution().goodNodes(treeNode);
        Assert.assertEquals(1, i);
    }
}
