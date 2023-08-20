package leetcode.p399;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Object[]>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            double value = values[i];
            String origin = list.get(0);
            String dest = list.get(1);

            if (!map.containsKey(origin)) {
                map.put(origin, new ArrayList<>());
            }
            if (!map.containsKey(dest)){
                map.put(dest, new ArrayList<>());
            }
            map.get(origin).add(new Object[]{dest, value, 1});
            map.get(dest).add(new Object[]{origin, value, -1});
        }

        double[] doubles = new double[queries.size()];
        for (int i = 0; i < doubles.length; i++) {

            doubles[i] = -1.0;
            List<String> query = queries.get(i);
            String origin = query.get(0);
            String dest = query.get(1);
            if (!map.containsKey(origin)) {
                continue;
            }
            if (origin.equals(dest)){
                doubles[i] = 1.0;
                continue;
            }

            Double[] container = new Double[1];
            Set<String> visited = new HashSet<>();
            visited.add(origin);
            iter(new ArrayList<>(), map, visited, origin, dest, container);

            if (container[0] != null) {
                doubles[i] = container[0];
            }

        }

        return doubles;
    }

    private void iter(List<Object[]> paths, Map<String, List<Object[]>> map, Set<String> visited, String origin, String dest, Double[] finalResult){

        if (!map.containsKey(origin)) {
            return;
        }

        if (visited.contains(dest)) {
            List<Object[]> normalOrders = paths.stream().filter(i -> (Integer) i[2] == 1).collect(Collectors.toList());
            List<Object[]> reverseOrders = paths.stream().filter(i -> (Integer) i[2] == -1).collect(Collectors.toList());
            double result = 1.0;
            for (Object[] normalOrder : normalOrders) {
                result *= (double)normalOrder[1];
            }
            for (Object[] reverseOrder : reverseOrders) {
                result *= 1.0 / (double)reverseOrder[1];
            }
            finalResult[0] = result;
            return;
        }

        List<Object[]> objects = map.get(origin);
        for (Object[] object : objects) {
            if (finalResult[0] != null) {
                break;
            }
            if (visited.contains((String)object[0])) {
                continue;
            }
            paths.add(object);
            visited.add((String)object[0]);
            iter(paths, map, visited, (String)object[0], dest, finalResult);
            paths.remove(paths.size()-1);
            visited.remove((String)object[0]);
        }
    }
}
