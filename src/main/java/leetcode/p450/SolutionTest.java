package leetcode.p450;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;

public class SolutionTest {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode result = new Solution().deleteNode(treeNode, 3);
        System.out.println(result);
    }
}
