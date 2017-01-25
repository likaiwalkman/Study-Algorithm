package jvm.monitor.util;

import java.lang.management.ManagementFactory;

public class JVMUtil {
    private static String pid;

    public final static String getPID() {

        if (pid == null) {
            String name = ManagementFactory.getRuntimeMXBean().getName();

            String[] items = name.split("@");

            pid = items[0];
        }

        return pid;
    }
}