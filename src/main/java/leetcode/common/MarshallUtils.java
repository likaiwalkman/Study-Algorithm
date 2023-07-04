package leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class MarshallUtils {
    public static TreeNode marshall(Integer[] arr){
        if (arr == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        List<TreeNode> roots = new ArrayList<>();

        roots.add(root);

        int index = 0;
        int count = 0;

        List<TreeNode> newRoots = new ArrayList<>();
        while (index < arr.length-1){
            index++;
            count++;

            Integer v = arr[index];
            TreeNode t = null;
            if (v != null) {
                t = new TreeNode(v);
            }
            newRoots.add(t);

            TreeNode parentTreeNode = roots.get(0);
            if (parentTreeNode != null) {
                if (count % 2 == 1) {
                    parentTreeNode.left = t;
                }else {
                    parentTreeNode.right = t;
                }
            }

            if (count == 2 ) {
                count = 0;
                roots.remove(0);
            }

            if (roots.size() == 0) {
                roots = newRoots;
                newRoots = new ArrayList<>();
            }
        }

        return root;
    }
}
