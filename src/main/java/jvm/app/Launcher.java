package jvm.app;

import concurrent.threadPool.copy.Executors;
import jvm.monitor.JVMGC;
import jvm.monitor.JVMInfo;
import jvm.monitor.JVMMemory;
import jvm.monitor.JVMThread;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.lang.System.out;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        final JVMGC jvmgc = JVMGC.getInstance();
        final JVMInfo jvmInfo = JVMInfo.getInstance();
        final JVMMemory jvmMemory = JVMMemory.getInstance();
        final JVMThread jvmThread = JVMThread.getInstance();

        final Object[] list = {JVMGC.getInstance(),
                JVMInfo.getInstance(),
                JVMMemory.getInstance(),
                JVMThread.getInstance()};
        new Thread(new Runnable() {
            public void run() {
                try {
                    new ServerSocket(9999).accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                List<List<String>> outerList = new LinkedList<List<String>>();
                while (true) {
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outerList.add(new ArrayList<String>(1000));
                }
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        while (true) {
            executorService.submit(new Runnable() {
                public void run() {
                    for (Object o : list) {
                        out.println(o);
                        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
                        //System.out.println(garbageCollectorMXBeans);

                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
            Thread.sleep(10000);
        }


    }
}
