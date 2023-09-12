package leetcode.p1022;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{1, 0, 1, 0, 1, 0, 1});
        int i = new Solution().sumRootToLeaf(treeNode);
        System.out.println(i);
    }
}
