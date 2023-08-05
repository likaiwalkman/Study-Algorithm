package leetcode.p129;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{4, 9, 0, 5, 1});
        int i = new Solution().sumNumbers(treeNode);
        Assert.assertEquals(1026, i);
    }

    @org.junit.Test
    public void test2(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{0, 1});
        int i = new Solution().sumNumbers(treeNode);
        Assert.assertEquals(1, i);
    }
}
