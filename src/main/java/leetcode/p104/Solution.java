package leetcode.p104;

import leetcode.common.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[]{1, 1};

        dfs(root, result);

        return result[1];

    }

    public void dfs(TreeNode treeNode, int[] result){
        if (treeNode.left == null && treeNode.right == null) {
            if (result[0] > result[1]) {
                result[1] = result[0];
            }
            return;
        }

        if (treeNode.left != null) {
            result[0] = result[0]+1;
            dfs(treeNode.left, result);
            result[0] = result[0]-1;
        }

        if (treeNode.right != null){
            result[0] = result[0]+1;
            dfs(treeNode.right, result);
            result[0] = result[0]-1;
        }
    }
}
