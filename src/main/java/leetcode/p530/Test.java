package leetcode.p530;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{4, 2, 6, 1, 3});
        int minimumDifference = new Solution().getMinimumDifference(treeNode);
        Assert.assertEquals(1, minimumDifference);
    }
}
