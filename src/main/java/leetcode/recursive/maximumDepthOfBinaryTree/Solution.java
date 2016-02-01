package leetcode.recursive.maximumDepthOfBinaryTree;
/*

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


* */

/**
 * Created by victor on 16/2/2.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = 1 + maxDepth(root.left);
            int right = 1 + maxDepth(root.right);
            return left > right ? left : right;
        }
    }
}