package leetcode.p230;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        int i = new Solution().kthSmallest(treeNode, 3);
        Assert.assertEquals(3, i);
    }

    @org.junit.Test
    public void test2(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{3,1,4,null,2});
        int i = new Solution().kthSmallest(treeNode, 1);
        Assert.assertEquals(1, i);
    }

    @org.junit.Test
    public void test3(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{4,2,5,1,3});
        int i = new Solution().kthSmallest(treeNode, 4);
        Assert.assertEquals(4, i);
    }

    @org.junit.Test
    public void test4(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{1, null, 2});
        int i = new Solution().kthSmallest(treeNode, 2);
        Assert.assertEquals(2, i);
    }

    @org.junit.Test
    public void test5(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{4,2,5,1,3});
        int i = new Solution().kthSmallest(treeNode, 4);
        Assert.assertEquals(4, i);
    }
}
