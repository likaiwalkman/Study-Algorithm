package consistentHash;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        SortedMap<Integer,String> circle = new TreeMap<Integer, String>();
        circle.put(2, "one");
        /*circle.put(1, "one");
        circle.put(1, "one");
        circle.put(1, "one");
        circle.put(1, "one");*/

        SortedMap<Integer, String> tailMap = circle.tailMap(2);
        System.out.println(tailMap);
    }
}
