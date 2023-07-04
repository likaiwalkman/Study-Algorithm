package leetcode.p104;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode root = MarshallUtils.marshall(new Integer[]{3, 9, 20, null, null, 15, 7});
        int i = new Solution().maxDepth(root);
        Assert.assertEquals(3, i);
    }
}
