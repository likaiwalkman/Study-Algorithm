package leetcode.p173.s2;

import leetcode.common.TreeNode;

import java.util.Stack;

public class BSTIterator {
    private final Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        stack.add(root);
        while (root.left != null){
            stack.add(root.left);
            root = root.left;
        }
    }


    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            TreeNode topRight = top.right;
            stack.push(topRight);
            while (topRight.left != null){
                stack.push(topRight.left);
                topRight = topRight.left;
            }

        }
        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
