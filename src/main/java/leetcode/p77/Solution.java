package leetcode.p77;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] ints = new int[n];
        for (int i = 0;  i< n; i++) {
            ints[i] = i+1;
        }

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        iter(results, visited, ints, k);
        return results;
    }

    private void iter(List<List<Integer>> results, List<Integer> visited, int[] ints, int k){
        if (visited.size() == k) {
            List<Integer> eleList = visited.stream().map(i -> ints[i]).collect(Collectors.toList());
            results.add(eleList);
            return;
        }

        int start = 0;
        if (visited.size()>0) {
            start = visited.get(visited.size()-1) + 1;
        }
        for (int i = start; i < ints.length; i++) {
            visited.add(i);
            iter(results, visited, ints, k);
            visited.remove(visited.size()-1);
        }

    }
}
