package clsloader.demo;

import clsloader.CustomizedClassloader;
import clsloader.StaticHolder;

public class SetContextClsLoaderTest {
    public static void main(String[] args) throws Exception {
        CustomizedClassloader customizedClassloader = new CustomizedClassloader();
        Thread.currentThread().setContextClassLoader(customizedClassloader);

        CustomizedClsLoaderThread thread = new CustomizedClsLoaderThread();
        thread.setContextClassLoader(customizedClassloader);
        thread.start();

        for (int i = 0; i < 10; i++) {
            StaticHolder staticHolder = new StaticHolder();
            int increment = StaticHolder.increment(123);
            System.out.println(increment);
            Thread.sleep(100000);
            thread.interrupt();
        }

    }
}
