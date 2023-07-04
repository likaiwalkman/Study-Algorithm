package leetcode.p124;


import leetcode.common.TreeNode;

public class Solution {

    public int maxPathSum(TreeNode root) {
        int[] arr = new int[]{Integer.MIN_VALUE};
        maxPathIter(root, arr);
        return arr[0];
    }

    public int partialMaxSum(Integer[] arr){
        int v = arr[0];
        Integer lmax = arr[1];
        Integer rmax = arr[2];

        int max = v;

        if (lmax != null){
            if (lmax > max) {
                max = lmax;
            }
            if (v + lmax > max) {
                max = v + lmax;
            }
        }
        if (rmax != null){
            if (rmax > max) {
                max = rmax;
            }

            if (v + rmax > max){
                max = v + rmax;
            }
        }

        if (lmax != null && rmax != null){
            if (v + rmax + lmax > max){
                max = v + lmax + rmax;
            }
        }
        return max;
    }

    public int partialMaxEdge(Integer[] arr){
        int v = arr[0];
        Integer lmax = arr[1];
        Integer rmax = arr[2];

        int max1 = v;
        if (lmax != null && lmax >= 0 ) {
            max1 += lmax;
        }
        int max2 = v;
        if (rmax != null && rmax >= 0){
            max2 += rmax;
        }
        return Math.max(max1, max2);
    }

    public int maxPathIter(TreeNode root, int[] arr){
        Integer lmax = null;
        if (root.left != null) {
            lmax = maxPathIter(root.left, arr);
        }
        Integer rmax = null;
        if (root.right != null){
            rmax = maxPathIter(root.right, arr);
        }

        Integer[] triple = {root.val, lmax, rmax};
        int max = partialMaxSum(triple);
        if (max > arr[0]) {
            arr[0] = max;
        }

        return partialMaxEdge(triple);
    }
}
