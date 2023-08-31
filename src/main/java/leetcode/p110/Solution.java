package leetcode.p110;

import leetcode.common.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean[] booleans = new boolean[1];
        depth(root, booleans);
        if (booleans[0]) {
            return false;
        }else {
            return true;
        }
    }

    private int depth(TreeNode node, boolean[] notBalanced){
        if (notBalanced[0]) {
            return 0;
        }
        if (node == null) {
            return 0;
        }
        int leftDepth  = depth(node.left,  notBalanced);
        int rightDepth = depth(node.right, notBalanced);
        if (notBalanced[0]) {
            return 0;
        }
        if (Math.abs(leftDepth-rightDepth) > 1) {
            notBalanced[0] = true;
            return 0;
        }
        return Math.max(1+leftDepth, 1+rightDepth);
    }
}
