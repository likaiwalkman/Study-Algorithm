package leetcode.p103;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test4(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> lists = new Solution().zigzagLevelOrder(treeNode);
        System.out.println(lists);
    }
}
