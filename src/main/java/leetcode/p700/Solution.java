package leetcode.p700;

import leetcode.common.TreeNode;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }else if (root.val < val){
            if (root.right == null){
                return null;
            }else {
                return searchBST(root.right, val);
            }
        }else {
            if (root.left == null){
                return null;
            }else {
                return searchBST(root.left, val);
            }
        }
    }
}
