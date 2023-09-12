package leetcode.p1022;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        int[] sum = new int[1];
        sumRootToLeafBacktrace(root, list, sum);
        return sum[0];
    }

    private void sumRootToLeafBacktrace(TreeNode root, List<Integer> list, int[] sum){
        if (root.left == null && root.right == null) {
            Iterator<Integer> iterator = list.iterator();
            int localSum = 0;
            while (iterator.hasNext()) {
                localSum *= 2;
                localSum += iterator.next();
            }
            sum[0] += localSum;
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            sumRootToLeafBacktrace(root.left, list, sum);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            sumRootToLeafBacktrace(root.right, list, sum);
            list.remove(list.size()-1);
        }
    }
}
