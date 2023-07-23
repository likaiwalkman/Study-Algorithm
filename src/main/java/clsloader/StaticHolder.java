package clsloader;

import org.apache.commons.lang.StringUtils;

public class StaticHolder {
    static Class<StaticHolder> clz = StaticHolder.class;

    public static int step;

    public static int increment(int value){
        if (NumberUtils.STEP != 2) {
            NumberUtils.STEP = 2;
        }

        //three watchers:
        Class<StringUtils> inner = StringUtils.class;
        Class<Object> obj = Object.class;
        Class<NumberUtils> numberUtilsClass = NumberUtils.class;

        if (StringUtils.endsWith(StringUtils.EMPTY+value, "0")) {
            System.out.println();
        }
        return value + step +NumberUtils.STEP;
    }
}
