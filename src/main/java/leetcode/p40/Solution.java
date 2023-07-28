package leetcode.p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    static int[] counter = new int[1];
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        List<Integer> item = new ArrayList<>();
//        List<List<Integer>> results = new ArrayList<>();
//        int[] sum = new int[1];
//        Arrays.sort(candidates);
//        iter(candidates, target, treeSet, item, results, sum);
//        return results;
//    }
//
//    private void iter(int[] candidates, int target,
//            TreeSet<Integer> treeSet, List<Integer> item,
//            List<List<Integer>> results, int[] sum){
//
//
//        if (sum[0] == target) {
//            List<Integer> copy = new ArrayList<>(item);
//            if (!results.contains(copy)) {
//                results.add(copy);
//            }
//            return;
//        }
//        if (sum[0] > target){
//            return;
//        }
//
//        int start = 0;
//        if (treeSet.size() > 0) {
//            start = treeSet.last()+1;
//        }
//        for (int i = start; i < candidates.length; i++) {
//            treeSet.add(i);
//            item.add(candidates[i]);
//            sum[0] += candidates[i];
//            counter[0]++;
//            System.out.println("counter:" +counter[0]+" push target:" + target + " sum:" + sum[0] +", item:"+item+" treeSet:"+treeSet);
//
//            int i0 = i;
//            if (sum[0] > target) {
//                i0 = candidates.length;
//            }else {
//                iter(candidates, target, treeSet, item, results, sum);
//            }
//
//            sum[0] -= candidates[i];
//            treeSet.remove(i);
//            item.remove(item.size()-1);
//            System.out.println("counter:" +counter[0]+" pop target:" + target + " sum:" + sum[0] +", item:"+item+" treeSet:"+treeSet);
//
//            i = i0;
//        }
//    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        List<Integer> item = new ArrayList<>();

        Arrays.sort(candidates);

        List<List<Integer>> results = new ArrayList<>();
        int[] sum = new int[1];

        iter(candidates, target, treeSet, item, results, sum);
        return results;
    }

    private void iter(int[] candidates, int target,
                      TreeSet<Integer> treeSet, List<Integer> item,
                      List<List<Integer>> results, int[] sum){


        if (sum[0] == target) {
            List<Integer> copy = new ArrayList<>(item);
            results.add(copy);
            return;
        }
        if (sum[0] > target){
            return;
        }

        int start = 0;
        if (treeSet.size() > 0) {
            start = treeSet.last()+1;
        }
        for (int i = start; i < candidates.length; i++) {
            treeSet.add(i);
            item.add(candidates[i]);
            sum[0] += candidates[i];
            int i0 = i;

            if (sum[0] > target) {
                i0 = candidates.length;
            }else {
                boolean notVisited = !visited(candidates, treeSet, item);
                if (notVisited) {
                    iter(candidates, target, treeSet, item, results, sum);
                }
            }

            sum[0] -= candidates[i];
            treeSet.remove(i);
            item.remove(item.size()-1);

            i = i0;
        }
    }

    private boolean visited(int[] candidates, TreeSet<Integer> treeSet, List<Integer> item){
        if (item.size() == 0) {
            return false;
        }

        for (Integer index : treeSet) {
            if(index -1 >=0 && !treeSet.contains(index-1) && candidates[index-1] == candidates[index]){
                return true;
            }
        }
        return false;
    }
}
