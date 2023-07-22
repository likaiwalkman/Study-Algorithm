package clsloader;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.*;
import java.util.*;

@SuppressWarnings("ALL")
public class CustomizedClassloader extends ClassLoader{
    public CustomizedClassloader(){
        super();
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = new byte[0];
        try {
            data = this.loadClassData(className);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Class<?> clz = this.defineClass(className, data, 0, data.length);
        ClassLoader classLoader = clz.getClassLoader();
        return clz;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("loadClass_1_params: "+" name:"+name);

        Class<?> clz = null;
        if (name.startsWith("clsloader.")) {
            clz = super.loadClass(name);
        }else {
            clz = ClassLoader.getSystemClassLoader().loadClass(name);
        }

        ClassLoader classLoader = clz.getClass().getClassLoader();
        return clz;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("loadClass_2_params: "+" name:"+name +" resolve:"+resolve);
        Class<?> clz = null;
        if (name.startsWith("clsloader.")) {
            clz = super.loadClass(name, resolve);
        }else {
            clz = ClassLoader.getSystemClassLoader().loadClass(name);
        }
        ClassLoader classLoader = clz.getClassLoader();
        return clz;
    }

    private byte[] loadClassFromJar(String className) throws IOException {
        String classpathStr = System.getProperty("java.class.path");
        String[] split = classpathStr.split(":");
        List<String> jarPaths = new ArrayList<>();
        for (String s : split) {
            if (s.endsWith(".jar")) {
                jarPaths.add(s);
            }
        }
        String jarClassFileWithoutClassSuffix = className.replaceAll("\\.", "/") ;
        String jarClassFileWithClassSuffix = jarClassFileWithoutClassSuffix + ".class";

        for (String jarFilePath : jarPaths) {
            String jarFileCLassURI = "jar:file:" + jarFilePath + "!/" + className.replaceAll("\\.", "/") + ".class";

            try {
                if (jarFilePath.contains("commons-lang")) {
                    System.err.println();
                }

                JarURLConnection jarURLConnection = (JarURLConnection) new URL(jarFileCLassURI).openConnection();
                jarURLConnection.connect();

                String jarFileUrl = "file:" + jarFilePath;
                URL[] jarFileUrls = {new URL(jarFileUrl)};
                URLClassLoader urlClassLoader = new URLClassLoader(jarFileUrls);
                InputStream stream = urlClassLoader.getResourceAsStream(jarClassFileWithClassSuffix);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int b = -1;
                while ((b = stream.read()) != -1) {
                    baos.write(b);
                }
                return baos.toByteArray();
            }catch (Exception e){
                //TODO error log or error handling
                continue;
            }
        }
        return null;
    }

    private byte[] loadClassData(String className) throws Exception{

        ClassLoader appClassLoader = getClass().getClassLoader();
        String classPath = className.replaceAll("\\.", "/");


        InputStream stream = appClassLoader.getResourceAsStream("./"+classPath + ".class");
        if (stream == null) {
            byte[] bytes = loadClassFromJar(className);
            return bytes;
        }else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = -1;
            while ((b = stream.read()) != -1) {
                baos.write(b);
            }
            return baos.toByteArray();
        }
    }



    public static void main(String[] args) throws Exception {
        Class<?> stringUtils = new CustomizedClassloader().findClass("org.apache.commons.lang.StringUtils");
        System.err.println(stringUtils);
        StaticHolder.step = 1;
        Class<?> isolatedStaticHolder = new CustomizedClassloader().findClass("clsloader.StaticHolder");
        Field vField = isolatedStaticHolder.getDeclaredField("step");
        vField.set(isolatedStaticHolder, 2);
        int staticHolderIncrementResult = StaticHolder.increment(1);
        Class<StaticHolder> staticHolderClass = StaticHolder.class;
        Method increment = isolatedStaticHolder.getDeclaredMethod("increment", new Class[]{int.class});
        Integer isolatedStaticHolderIncrementResult = (Integer) increment.invoke(isolatedStaticHolder, 1);

        assert isolatedStaticHolderIncrementResult == 3;
        assert staticHolderIncrementResult == 2;

        LinkedList<CustomizedClassloader> customizedClassloaders = new LinkedList<>();

        while (true){
            System.gc();

            URLConnection urlConnection = new URL("http://www.baidu.com").openConnection();
            urlConnection.connect();
            int contentLength = urlConnection.getContentLength();
            System.out.println("content-length:"+contentLength);

            CustomizedClassloader customizedClassloader = new CustomizedClassloader();
            System.err.println("customizedClassloader: "+customizedClassloader);
            Class<?> stringUtilsClz = customizedClassloader.findClass("org.apache.commons.lang.StringUtils");
            Class<?> staticHolderClz = customizedClassloader.findClass("clsloader.StaticHolder");

            new ClassInfoHelper().collectAllClassloaderClassSet();

            customizedClassloaders.add(customizedClassloader);
            if (customizedClassloaders.size() > 10) {
                customizedClassloaders.removeFirst();
            }

            Thread.sleep(5000);
        }
    }


}
