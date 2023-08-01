package leetcode.p112;

import leetcode.common.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return iter(root, targetSum, 0);
    }

    private boolean iter(TreeNode root, int target, int sum){
        sum += root.val;
        if (sum == target && root.left == null && root.right == null){
            return true;
        }
        if (root.left != null){
            boolean res = iter(root.left, target, sum);
            if (res){
                return true;
            }
        }
        if (root.right != null){
            boolean res = iter(root.right, target, sum);
            if (res){
                return true;
            }
        }
        return false;
    }
}
