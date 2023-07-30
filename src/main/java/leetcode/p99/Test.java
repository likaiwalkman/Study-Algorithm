package leetcode.p99;

import leetcode.common.MarshallUtils;
import leetcode.common.TreeNode;

public class Test {
    @org.junit.Test
    public void test1(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{1,3,null,null,2});
        new Solution().recoverTree(treeNode);
        System.out.println();
    }

    @org.junit.Test
    public void test2(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{3,1,4,null,null,2});
        new Solution().recoverTree(treeNode);
        System.out.println();
    }

    @org.junit.Test
    public void test3(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{0, 1});
        new Solution().recoverTree(treeNode);
        System.out.println();
    }

    @org.junit.Test
    public void test4(){
        TreeNode treeNode = MarshallUtils.marshall(new Integer[]{5,3,9,-2147483648,2});
        new Solution().recoverTree(treeNode);
        System.out.println();
    }
}
