package stringformat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by victor on 16/1/26.
 */
public class App {
    public static void main(String[] args) {
        //placeholders to be replaced with latter letters
        System.out.println(String.format("%s%s select 1,2 %s","begin transaction;","", "order by id desc", ""));
        System.out.println(String.format("select a,b,c from a %s,select 1,2 %s","where 1=1","order by id desc"));

        StringBuilder input = new StringBuilder("{a=@a, b=@b, c=@c, d=@d, e=@e}");
        for (Map.Entry<String, Object> pair : map.entrySet()) {
            String key = "@"+pair.getKey();
            Object val = pair.getValue();
            int start = input.indexOf(key);
            input.replace(start, start + key.length(), val.toString());
        }
        System.out.println(input.toString());

    }
    static Map<String, Object> map = new HashMap<String, Object>();
    static {
        char c = 'a';
        for (int i = 0; i < 5; i++) {
            map.put(((Character)(char)(c+i)).toString(),((Character)(char)(c+i)).toString().toUpperCase());
        }
    }
}
