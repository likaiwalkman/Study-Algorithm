package clsloader;

import java.util.Vector;

public class ClassInfoHelper {
    public void collectAllClassloaderClassSet() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        Object[] list = list(classLoader);
    }

    private static Object[] list(ClassLoader classLoader)
            throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        if (classLoader == null) {
            return null;
        }
        Class classloaderClassSelf = classLoader.getClass();
        while (classloaderClassSelf != java.lang.ClassLoader.class) {
            classloaderClassSelf = classloaderClassSelf.getSuperclass();
        }
        java.lang.reflect.Field ClassLoader_classes_field = classloaderClassSelf.getDeclaredField("classes");
        ClassLoader_classes_field.setAccessible(true);
        Vector<Class> vector = (Vector) ClassLoader_classes_field.get(classLoader);
        for (Class clz : vector) {
            Object clzObj = clz;
            System.err.println("clz: "+clz+" classloader:"+classLoader);
            if (clzObj instanceof ClassLoader){
                //list((ClassLoader)clz);
            }
        }
        Object[] classesAndItsLoader = new Object[]{vector.iterator(), classLoader};
        return classesAndItsLoader;
    }
}
