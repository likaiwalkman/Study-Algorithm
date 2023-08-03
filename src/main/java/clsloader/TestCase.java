package clsloader;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

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

    @Test
    public void test04() throws Exception{
        Object[] results = new Object[2];
        for (int i = 0; i < 2; i++) {
            CustomizedClassloader customizedClassloader1 = new CustomizedClassloader();
            Class<?> isolatedStaticHolder = customizedClassloader1.findClass("clsloader.StaticHolder");
            Field vField = isolatedStaticHolder.getDeclaredField("step");
            vField.set(isolatedStaticHolder, 2);

            Method increment = isolatedStaticHolder.getDeclaredMethod("increment", new Class[]{ int.class });
            Integer isolatedStaticHolderIncrementResult = (Integer) increment.invoke(null, 1);
            results[i] = isolatedStaticHolder.getDeclaredMethod("inspectClasses", new Class[]{}).invoke(null);
        }
        System.out.println(results);
        List<Object> result0 = (List<Object>) results[0];
        List<Object> result1 = (List<Object>) results[1];
        Assert.assertTrue(result0.size() == 3);
        Assert.assertTrue(result1.size() == 3);
        Assert.assertTrue(result0.get(0) == result1.get(0));
        Assert.assertTrue(result0.get(1) == result1.get(1));
        Assert.assertTrue(result0.get(2) != result1.get(2));
    }
}
