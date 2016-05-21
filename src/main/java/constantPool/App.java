package constantPool;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * test
 * Created by victor on 16/4/28.
 */
public class App {
    public static void main(String[] args) {
        System.out.println(A.a == B.b);
        Map<String, Integer> map = new HashMap<>();//new LinkedHashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        System.out.println(map);
    }
}
