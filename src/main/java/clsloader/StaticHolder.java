package clsloader;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Object> inspectClasses(){
        Class<StringUtils> clz1 = StringUtils.class;
        Class<Object> clz2 = Object.class;
        Class<NumberUtils> clz3 = NumberUtils.class;
        List<Object> classes = new ArrayList<>();
        classes.add(clz1);
        classes.add(clz2);
        classes.add(clz3);
        return classes;
    }
}
