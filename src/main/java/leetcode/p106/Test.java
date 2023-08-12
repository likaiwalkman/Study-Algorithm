package leetcode.p106;

import leetcode.common.TreeNode;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = new Solution().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
