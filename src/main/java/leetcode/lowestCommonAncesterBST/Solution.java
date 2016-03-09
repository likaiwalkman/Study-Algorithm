package leetcode.lowestCommonAncesterBST;

import java.util.LinkedList;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * -------_______6______
 * ------/              \
 * ---___2__          ___8__
 * --/      \        /      \
 * -0       4       7       9
 * -------/  \
 * ------3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */


class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pPath = new LinkedList<TreeNode>();
        LinkedList<TreeNode> qPath = new LinkedList<TreeNode>();
        TreeNode             temp  = root;
        while (temp != null && p.val != temp.val) {
            pPath.addFirst(temp);
            if (p.val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        pPath.addFirst(p);

        temp = root;
        while (temp != null && q.val != temp.val) {
            qPath.addFirst(temp);
            if (q.val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        qPath.addFirst(q);
        for (int i = 0; i < qPath.size(); i++) {
            TreeNode treeNode = qPath.get(i);
            if (pPath.contains(treeNode)) {
                return treeNode;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode one   = new TreeNode(1);
        TreeNode two   = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four  = new TreeNode(4);
        TreeNode five  = new TreeNode(5);
        TreeNode six   = new TreeNode(6);

        two.left = one;

        three.left = two;
        three.right = four;

        five.left = three;
        five.right = six;

        TreeNode n = new Solution().lowestCommonAncestor(five, one, four);
        System.out.println(n.val);
    }
}
