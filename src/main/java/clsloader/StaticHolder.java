package clsloader;

import org.apache.commons.lang.StringUtils;

public class StaticHolder {
    static Class<StaticHolder> clz = StaticHolder.class;

    public static int step;
    public static int increment(int value){
        Class<StringUtils> inner = StringUtils.class;
        if (StringUtils.endsWith(StringUtils.EMPTY+value, "0")) {
            System.out.println();
        }
        return value + step;
    }
}
