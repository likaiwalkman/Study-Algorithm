package leetcode.p108;

import leetcode.common.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getRoot(nums, 0, nums.length-1);
    }

    TreeNode getRoot(int nums[], int start, int end){
        int mid = (start + end) / 2;
        if (end-start == 1){
            mid = end;
        }

        TreeNode node = new TreeNode(nums[mid]);
        if (mid > start) {
            TreeNode left = getRoot(nums, start, mid-1);
            node.left = left;
        }
        if (mid+1 <= end){
            TreeNode right = getRoot(nums, mid+1, end);
            node.right = right;
        }
        return node;
    }
}
