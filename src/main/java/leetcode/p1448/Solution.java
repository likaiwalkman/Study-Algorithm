package leetcode.p1448;

import leetcode.common.TreeNode;

public class Solution {
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        int max = Integer.MIN_VALUE;
        dfs(root, count, max);
        return count[0];
    }

    private void dfs(TreeNode root, int[] count, int max){
        if (root.val >= max) {
            count[0]++;
            max = root.val;
        }
        if (root.left != null) {
            dfs(root.left, count, max);
        }
        if (root.right != null) {
            dfs(root.right, count, max);
        }
    }
}
