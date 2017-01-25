package jvm.monitor;

import jvm.monitor.util.JVMUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

public class JVMMemory implements JVMMemoryMBean {
    private static final Logger logger = LoggerFactory.getLogger(JVMMemory.class);

    private static JVMMemory instance = new JVMMemory();

    private MemoryMXBean memoryMXBean;
    private MemoryPoolMXBean permGenMXBean;
    private MemoryPoolMXBean oldGenMXBean;
    private MemoryPoolMXBean edenSpaceMXBean;
    private MemoryPoolMXBean psSurvivorSpaceMXBean;

    private static JVMMemory getInstance() {
        return JVMMemory.instance;
    }

    private JVMMemory() {
        this.memoryMXBean = ManagementFactory.getMemoryMXBean();
        List<MemoryPoolMXBean> list = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean item : list) {
            if ("CMS Perm Gen".equals(item.getName()) // -XX:+UseConcMarkSweepGC
                    || "Perm Gen".equals(item.getName()) // -XX:+UseSerialGC -XX:+UseParNewGC
                    || "PS Perm Gen".equals(item.getName()) // –XX:+UseParallelGC -XX:+UseParallelOldGC
                    || "G1 Perm Gen".equals(item.getName()) // -XX:+CMSClassUnloadingEnabled
                    ) {
                this.permGenMXBean = item;// GC下的持久代
            } else if ("CMS Old Gen".equals(item.getName()) // -XX:+UseConcMarkSweepGC
                    || "Tenured Gen".equals(item.getName()) // -XX:+UseSerialGC
                    || "PS Old Gen".equals(item.getName()) // –XX:+UseParallelGC -XX:+UseParallelOldGC
                    || "G1 Old Gen".equals(item.getName()) // -XX:+CMSClassUnloadingEnabled
                    ) {
                this.oldGenMXBean = item;// GC下的老年代
            } else if ("Par Eden Space".equals(item.getName()) // -XX:+UseConcMarkSweepGC -XX:+UseParNewGC
                    || "Eden Space".equals(item.getName()) // -XX:+UseSerialGC
                    || "PS Eden Space".equals(item.getName()) // –XX:+UseParallelGC -XX:+UseParallelOldGC
                    || "G1 Eden".equals(item.getName()) // -XX:+CMSClassUnloadingEnabled
                    ) {
                this.edenSpaceMXBean = item;// GC下的年轻代Eden区
            } else if ("Par Survivor Space".equals(item.getName()) // -XX:+UseConcMarkSweepGC
                    || "Survivor Space".equals(item.getName()) // -XX:+UseSerialGC -XX:+UseParNewGC
                    || "PS Survivor Space".equals(item.getName()) // –XX:+UseParallelGC -XX:+UseParallelOldGC
                    || "G1 Survivor".equals(item.getName()) // -XX:+CMSClassUnloadingEnabled
                    ) {
                this.psSurvivorSpaceMXBean = item;// GC下的年轻代Survivor区
            }
        }
    }

    @Override
    public long getHeapMemoryCommitted() {
        return this.memoryMXBean.getHeapMemoryUsage().getCommitted();
    }

    @Override
    public long getHeapMemoryInit() {
        return this.memoryMXBean.getHeapMemoryUsage().getInit();
    }

    @Override
    public long getHeapMemoryMax() {
        return this.memoryMXBean.getHeapMemoryUsage().getMax();
    }

    @Override
    public long getHeapMemoryUsed() {
        return this.memoryMXBean.getHeapMemoryUsage().getUsed();
    }

    @Override
    public long getNonHeapMemoryCommitted() {
        return this.memoryMXBean.getNonHeapMemoryUsage().getCommitted();
    }

    @Override
    public long getNonHeapMemoryInit() {
        return this.memoryMXBean.getNonHeapMemoryUsage().getInit();
    }

    @Override
    public long getNonHeapMemoryMax() {
        return this.memoryMXBean.getNonHeapMemoryUsage().getMax();
    }

    @Override
    public long getNonHeapMemoryUsed() {
        return this.memoryMXBean.getNonHeapMemoryUsage().getUsed();
    }

    @Override
    public long getPermGenCommitted() {
        if (null == this.permGenMXBean) {
            return 0;
        }
        return this.permGenMXBean.getUsage().getCommitted();
    }

    @Override
    public long getPermGenInit() {
        if (null == this.permGenMXBean) {
            return 0;
        }
        return this.permGenMXBean.getUsage().getInit();
    }

    @Override
    public long getPermGenMax() {
        if (null == this.permGenMXBean) {
            return 0;
        }
        return this.permGenMXBean.getUsage().getMax();
    }

    @Override
    public long getPermGenUsed() {
        if (null == this.permGenMXBean) {
            return 0;
        }
        return this.permGenMXBean.getUsage().getUsed();
    }

    @Override
    public long getOldGenCommitted() {
        if (null == this.oldGenMXBean) {
            return 0;
        }
        return this.oldGenMXBean.getUsage().getCommitted();
    }

    @Override
    public long getOldGenInit() {
        if (null == this.oldGenMXBean) {
            return 0;
        }
        return this.oldGenMXBean.getUsage().getInit();
    }

    @Override
    public long getOldGenMax() {
        if (null == this.oldGenMXBean) {
            return 0;
        }
        return this.oldGenMXBean.getUsage().getMax();
    }

    @Override
    public long getOldGenUsed() {
        if (null == this.oldGenMXBean) {
            return 0;
        }
        return this.oldGenMXBean.getUsage().getUsed();
    }

    @Override
    public long getEdenSpaceCommitted() {
        if (null == this.edenSpaceMXBean) {
            return 0;
        }
        return this.edenSpaceMXBean.getUsage().getCommitted();
    }

    @Override
    public long getEdenSpaceInit() {
        if (null == this.edenSpaceMXBean) {
            return 0;
        }
        return this.edenSpaceMXBean.getUsage().getInit();
    }

    @Override
    public long getEdenSpaceMax() {
        if (null == this.edenSpaceMXBean) {
            return 0;
        }
        return this.edenSpaceMXBean.getUsage().getMax();
    }

    @Override
    public long getEdenSpaceUsed() {
        if (null == this.edenSpaceMXBean) {
            return 0;
        }
        return this.edenSpaceMXBean.getUsage().getUsed();
    }

    @Override
    public long getSurvivorCommitted() {
        if (null == this.psSurvivorSpaceMXBean) {
            return 0;
        }
        return this.psSurvivorSpaceMXBean.getUsage().getCommitted();
    }

    @Override
    public long getSurvivorInit() {
        if (null == this.psSurvivorSpaceMXBean) {
            return 0;
        }
        return this.psSurvivorSpaceMXBean.getUsage().getInit();
    }

    @Override
    public long getSurvivorMax() {
        if (null == this.psSurvivorSpaceMXBean) {
            return 0;
        }
        return this.psSurvivorSpaceMXBean.getUsage().getMax();
    }

    @Override
    public long getSurvivorUsed() {
        if (null == this.psSurvivorSpaceMXBean) {
            return 0;
        }
        return this.psSurvivorSpaceMXBean.getUsage().getUsed();
    }

    @Override
    public String getPID() {
        return JVMUtil.getPID();
    }
}
