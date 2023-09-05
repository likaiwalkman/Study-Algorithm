package leetcode.p146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer, Integer> cache = null;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(16, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer i = cache.get(key);
        if (i == null) {
            return -1;
        }
        return i;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
