package clsloader.system;

import sun.misc.Launcher;
import sun.misc.URLClassPath;

public class ClzLoader {
    public static void main(String[] args) {
        Launcher launcher = Launcher.getLauncher();
        ClassLoader classLoader = launcher.getClassLoader();
        URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
        System.out.println(classLoader);
    }
}
