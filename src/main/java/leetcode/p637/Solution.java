package leetcode.p637;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> results = new ArrayList<>();
        List<TreeNode> seeds = new ArrayList<>();
        seeds.add(root);
        while (seeds.size() > 0){
            double sum = 0;
            List<TreeNode> temp = new ArrayList<>();
            for (int i = 0; i < seeds.size(); i++) {
                TreeNode node = seeds.get(i);
                sum += node.val;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null){
                    temp.add(node.right);
                }
            }
            results.add(sum / seeds.size());
            seeds = temp;
        }
        return results;
    }
}
