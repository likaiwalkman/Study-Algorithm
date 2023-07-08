package leetcode.p22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> path = new ArrayList<>();
        List<String> results = new ArrayList<>();
        iter(path, results, n, 0, 0);
        return results;
    }
    public void iter(List<String> path, List<String> results, int n, int openSize, int closeSize){
        if (path.size() == 2*n){
            StringBuilder builder = new StringBuilder();
            for (String s : path) {
                builder.append(s);
            }
            results.add(builder.toString());
            return;
        }
        if (openSize == closeSize){
            path.add("(");
            openSize++;
            iter(path, results, n, openSize, closeSize);
            path.remove(path.size()-1);
            openSize--;
        }else {
            if (openSize < n) {
                path.add("(");
                openSize++;
                iter(path, results, n, openSize, closeSize);
                path.remove(path.size()-1);
                openSize--;
            }
            if (closeSize < n) {
                path.add(")");
                closeSize++;
                iter(path, results, n, openSize, closeSize);
                path.remove(path.size()-1);
                closeSize--;
            }
        }
    }
}
