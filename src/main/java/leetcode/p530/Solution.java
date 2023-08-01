package leetcode.p530;

import leetcode.common.TreeNode;

public class Solution {
    public int getMinimumDifference(TreeNode root) {
        int[] min = {Integer.MAX_VALUE};
        TreeNode[] last = new TreeNode[1];
        iter(last, root, min);
        return min[0];
    }

    private void iter(TreeNode[] last, TreeNode root, int[] min){
        if (root.left != null) {
            iter(last, root.left, min);
        }
        if (last[0] != null) {
            if (root.val - last[0].val == 0) {
                min[0] = 0;
                return;
            }else if (root.val - last[0].val < min[0]) {
                min[0] = root.val - last[0].val;
            }
        }
        last[0] = root;
        if (root.right != null) {
            iter(last, root.right, min);
        }
    }
}
