package leetcode.p129;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> edges = new ArrayList<>();
        int[] sum = new int[1];
        iter(edges, sum, root);

        return sum[0];
    }

    private void iter(List<Integer> edges, int[] sum, TreeNode node){
        if (node.left == null && node.right == null) {
            edges.add(node.val);
            List<Integer> temp = new ArrayList<>();
            boolean flag = false;
            for (int i = 0; i < edges.size(); i++) {
                if (!flag && edges.get(i) != 0) {
                    flag = true;
                }
                if (flag){
                    temp.add(edges.get(i));
                }
            }
            int item = 0;
            for (int i = 0; i < temp.size(); i++) {
                item *= 10;
                item += temp.get(i);
            }
            System.out.println(item);
            sum[0] += item;
            edges.remove(edges.size()-1);
            return;
        }

        if (node.left != null) {
            edges.add(node.val);
            iter(edges, sum, node.left);
            edges.remove(edges.size()-1);
        }

        if (node.right != null){
            edges.add(node.val);
            iter(edges, sum, node.right);
            edges.remove(edges.size()-1);
        }
    }
}
