package leetcode.p108;

import leetcode.common.TreeNode;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }
}
