package leetcode.p637;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{3, 9, 20, 15, 7});
        List<Double> doubles = new Solution().averageOfLevels(treeNode);
        System.out.println(doubles);
    }
}
