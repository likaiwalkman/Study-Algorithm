package leetcode.p173.s1;

import leetcode.common.TreeNode;
import java.util.ArrayList;

public class BSTIterator {
    private final ArrayList<TreeNode> arrayList = new ArrayList<>();
    private int cursor = -1;

    public BSTIterator(TreeNode root) {
        midOrder(root, arrayList);
    }

    private void midOrder(TreeNode treeNode, ArrayList<TreeNode> arrayList){
        if (treeNode.left != null) {
            midOrder(treeNode.left, arrayList);
        }
        arrayList.add(treeNode);
        if (treeNode.right != null) {
            midOrder(treeNode.right, arrayList);
        }
    }

    public int next() {
        cursor++;
        return arrayList.get(cursor).val;
    }

    public boolean hasNext() {
        return cursor < arrayList.size()-1;
    }
}
