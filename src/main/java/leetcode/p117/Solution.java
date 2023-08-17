package leetcode.p117;

import leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        List<Node> seeds = new ArrayList<>();
        seeds.add(root);

        while (!seeds.isEmpty()){
            List<Node> newSeeds = new ArrayList<>();
            for (int i = 0; i < seeds.size(); i++) {
                if (i < seeds.size()-1) {
                    seeds.get(i).next = seeds.get(i+1);
                }
                if (seeds.get(i).left != null) {
                    newSeeds.add(seeds.get(i).left);
                }
                if (seeds.get(i).right != null) {
                    newSeeds.add(seeds.get(i).right);
                }
            }
            seeds = newSeeds;
        }
        return root;
    }
}
