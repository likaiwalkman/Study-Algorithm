package clsloader;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestCase {
    @Test
    public void test01() throws Exception{
        Class<CustomizedClassloader> customizedClassloaderClass = CustomizedClassloader.class;
        String customizedClassloaderClassPosition = customizedClassloaderClass.getResource(StringUtils.EMPTY).toString();
        String stringUtilsClassPosition = StringUtils.class.getResource(StringUtils.EMPTY).toString();
        System.err.println(customizedClassloaderClassPosition);
        System.err.println(stringUtilsClassPosition);
    }

    @Test
    public void test02() throws Exception{
        String classpathStr = System.getProperty("java.class.path");
        System.err.print(classpathStr);
    }

    @Test
    public void test03() throws Exception{
        CustomizedClassloader customizedClassloader = new CustomizedClassloader();
        Class<?> isolatedStaticHolder = customizedClassloader.findClass("clsloader.StaticHolder");
        Field vField = isolatedStaticHolder.getDeclaredField("step");
        vField.set(isolatedStaticHolder, 2);

        Method increment = isolatedStaticHolder.getDeclaredMethod("increment", new Class[]{ int.class });
        Integer isolatedStaticHolderIncrementResult = (Integer) increment.invoke(null, 1);

        Assert.assertEquals(5, isolatedStaticHolderIncrementResult.intValue());

        int res = StaticHolder.increment(1);
        Assert.assertEquals(3, res);
    }
}
