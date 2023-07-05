package leetcode.p105;

import leetcode.common.TreeNode;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
