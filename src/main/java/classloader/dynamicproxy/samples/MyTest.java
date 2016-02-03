package classloader.dynamicproxy.samples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class MyTest {

    public static void main(String[] args) throws IOException {
        //读取本地的class文件内的字节码，转换成字节码数组
        File        file   = new File(".");
        InputStream input  = //new FileInputStream(file.getCanonicalPath() + "\\bin\\samples\\Programmer.class");
        MyTest.class.getClassLoader().getResource("classloader/dynamicproxy/samples/Programmer.class").openStream();
        byte[]      result = new byte[1024];

        int count = input.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        MyClassLoader loader = new MyClassLoader();
        Class         clazz  = loader.defineMyClass(result, 0, count);
        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());

        //实例化一个Programmer对象
        try {
            Object o = clazz.newInstance();
            //调用Programmer的code方法
            clazz.getMethod("code", null).invoke(o, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}