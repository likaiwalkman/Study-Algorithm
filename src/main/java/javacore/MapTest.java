package javacore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> item = iterator.next();
            map.remove(item.getKey());
        }
    }
}
