package leetcode.p114;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{1, 2, 5, 3, 4, null, 6});
        new Solution().flatten(treeNode);
        System.out.println();
    }
}
