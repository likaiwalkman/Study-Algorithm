package dynamicProxy.samples;

public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass(byte[] b, int off, int len) {
        //"classloader.dynamicproxy.samples.Programmer1",
        return super.defineClass(b, off, len);
    }

}
