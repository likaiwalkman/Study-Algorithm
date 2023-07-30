package leetcode.p173;

import leetcode.common.TreeNode;

public class BSTIterator {
    private TreeNode lastVisitedNode = null;
    private TreeNode lastNode = null;
    private TreeNode treeNode = null;

    public BSTIterator(TreeNode root) {
        if (root != null) {
            this.treeNode = root;
            midOrder(root);
        }
    }

    private void midOrder(TreeNode treeNode){
        if (treeNode.left != null) {
            midOrder(treeNode.left);
        }
        lastNode = treeNode;
        if (treeNode.right != null) {
            midOrder(treeNode.right);
        }
    }

    private void next(TreeNode treeNode){
        if (treeNode.left != null) {
            next(treeNode.left);
        }
        if (lastVisitedNode == null){
            lastVisitedNode = treeNode;
            return;
        }else if (lastVisitedNode == treeNode){
            lastVisitedNode = null;
        }
        if (treeNode.right != null) {
            next(treeNode.right);
        }
    }

    public int next() {
        next(treeNode);
        return lastVisitedNode.val;
    }

    public boolean hasNext() {
        return lastVisitedNode != lastNode;
    }
}
