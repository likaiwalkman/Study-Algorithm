package jvm.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JVMGC implements JVMGCMBean {
    public static final Logger logger = LoggerFactory.getLogger(JVMGC.class);
    public static JVMGC instance;

    public static JVMGC getInstance() {
        if (null == JVMGC.instance) {
            JVMGC.instance = new JVMGC();
        }
        return JVMGC.instance;
    }

    private GarbageCollectorMXBean fullGCMXBean;
    private GarbageCollectorMXBean youngGCMXBean;
    private RuntimeMXBean runtimeMXBean;

    private long lastYoungGCCollectionCount = 0;
    private long lastYoungGCCollectionTime = 0;
    private long lastFullGCCollectionCount = 0;
    private long lastFullGCCollectionTime = 0;

    private volatile long lastGCTime;
    private volatile long lastGCUpTime;

    private static final Map<String, Object> fullGCMXBeanNameMap = new HashMap();
    private static final Map<String, Object> youngGCMXBeanNameMap = new HashMap();


    private JVMGC() {
        if (null == fullGCMXBeanNameMap || null == youngGCMXBeanNameMap) {
            fullGCMXBeanNameMap.put("ConcurrentMarkSweep", null);// -XX:+UseConcMarkSweepGC
            fullGCMXBeanNameMap.put("MarkSweepCompact", null);// -XX:+UseSerialGC
            fullGCMXBeanNameMap.put("PS MarkSweep", null);// -XX:+UseParallelGC and (-XX:+UseParallelOldGC or -XX:+UseParallelOldGCCompacting)

            fullGCMXBeanNameMap.put("G1 Old Generation", null);
            fullGCMXBeanNameMap.put("Garbage collection optimized for short pausetimes Old Collector", null);
            fullGCMXBeanNameMap.put("Garbage collection optimized for throughput Old Collector", null);
            fullGCMXBeanNameMap.put("Garbage collection optimized for deterministic pausetimes Old Collector", null);

            youngGCMXBeanNameMap.put("ParNew", null);// -XX:+UseParNewGC
            youngGCMXBeanNameMap.put("Copy", null);// -XX:+UseSerialGC
            youngGCMXBeanNameMap.put("PS Scavenge", null);// -XX:+UseParallelGC
            youngGCMXBeanNameMap.put("G1 Young Generation", null);
            youngGCMXBeanNameMap.put("Garbage collection optimized for short pausetimes Young Collector", null);
            youngGCMXBeanNameMap.put("Garbage collection optimized for throughput Young Collector", null);
            youngGCMXBeanNameMap.put("Garbage collection optimized for deterministic pausetimes Young Collector", null);
        }

        List<GarbageCollectorMXBean> gcMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcMXBean : gcMXBeans) {
            String name = gcMXBean.getName();
            if (JVMGC.fullGCMXBeanNameMap.containsKey(name)) {
                this.fullGCMXBean = gcMXBean;
            } else if (JVMGC.youngGCMXBeanNameMap.containsKey(name)) {
                this.youngGCMXBean = gcMXBean;
            }
        }

        this.runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        try {
            this.lastGCTime = this.getFullGCCollectionTime() + this.getYoungGCCollectionTime();
            this.lastGCUpTime = this.getUpTime();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }


    @Override
    public long getYoungGCCollectionCount() {
        if (this.youngGCMXBean == null) {
            return 0;
        } else {
            return this.youngGCMXBean.getCollectionCount();
        }
    }

    @Override
    public long getYoungGCCollectionTime() {
        if (this.youngGCMXBean == null) {
            return 0;
        } else {
            return this.youngGCMXBean.getCollectionTime();
        }
    }

    @Override
    public long getFullGCCollectionCount() {
        if (this.fullGCMXBean == null) {
            return 0;
        } else {
            return this.fullGCMXBean.getCollectionCount();
        }
    }

    @Override
    public long getFullGCCollectionTime() {
        if (this.fullGCMXBean == null) {
            return 0;
        } else {
            return this.fullGCMXBean.getCollectionTime();
        }
    }

    @Override
    public long getSpanYoungGCCollectionCount() {
        long current = this.getYoungGCCollectionCount();
        long result = current - this.lastYoungGCCollectionCount;
        this.lastYoungGCCollectionCount = current;
        return result;
    }

    @Override
    public long getSpanYoungGCCollectionTime() {
        long current = this.getYoungGCCollectionTime();
        long result = current - this.lastYoungGCCollectionTime;
        this.lastYoungGCCollectionTime = current;
        return result;
    }

    @Override
    public long getSpanFullGCCollectionCount() {
        long current = this.getFullGCCollectionCount();
        long result = current - this.lastFullGCCollectionCount;
        lastFullGCCollectionCount = current;
        return result;
    }

    @Override
    public long getSpanFullGCCollectionTime() {
        long current = this.getFullGCCollectionTime();
        long result = current - this.lastFullGCCollectionTime;
        this.lastFullGCCollectionTime = current;
        return result;
    }

    @Override
    public BigDecimal getFullGCCollectionTimeRate() {
        long gcTime = this.getFullGCCollectionTime() + this.getYoungGCCollectionTime();
        long upTime = this.runtimeMXBean.getUptime();

        long elapsedGC =  gcTime - this.lastGCTime;
        long elapsedTime = upTime - this.lastGCUpTime;

        BigDecimal gcRate;
        if (elapsedTime <= 0) {
            gcRate = new BigDecimal(0);
        } else {
            float gcUsage = (elapsedGC * 10F) / elapsedTime;
            gcRate = new BigDecimal(gcUsage, new MathContext(4));
        }

        this.lastGCTime = gcTime;
        this.lastGCUpTime = upTime;

        return gcRate;
    }

    private long getUpTime() {
        return this.runtimeMXBean.getUptime();
    }
}
