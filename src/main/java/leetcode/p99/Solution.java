package leetcode.p99;

import leetcode.common.TreeNode;

public class Solution {
    public void recoverTree(TreeNode root) {
        int[] count = new int[1];
        TreeNode[][] node = new TreeNode[2][];
        for (int i = 0; i < 2; i++) {
            node[i] = new TreeNode[2];
        }
        TreeNode head = root;
        TreeNode[] prev = new TreeNode[2];
        //prev[0] = head;
        middleOrder(head, count, node, prev);

        if (count[0] == 2) {
            int temp = node[0][0].val;
            node[0][0].val = node[1][1].val;
            node[1][1].val = temp;
        }else {
            int temp = node[0][0].val;
            node[0][0].val = node[0][1].val;
            node[0][1].val = temp;
        }

    }

    private void middleOrder(TreeNode head, int[] count,TreeNode[][] node, TreeNode[] prev){
        if (head.left != null) {
            middleOrder(head.left, count, node, prev);
        }
        if (prev[0] != null) {
            if (prev[0].val > head.val) {
                if (count[0] == 0) {
                    node[count[0]++] = new TreeNode[]{prev[0], head};
                }else {
                    node[count[0]++] = new TreeNode[]{prev[0], head};
                }
            }
        }
        if (count[0] == 2) {
            return;
        }
        prev[0] = head;
        if (head.right != null) {
            middleOrder(head.right, count, node, prev);
        }
    }
}
