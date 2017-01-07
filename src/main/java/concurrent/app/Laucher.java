package concurrent.app;

import concurrent.ConcurrentHashMap;

public class Laucher {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        String key = "1";
        map.put(key, "");
        String s = map.get(key);
        String old = map.remove(key);
        int size = map.size();
        System.out.println(size);
        System.out.println(s.equals(old));
    }
}
