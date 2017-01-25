package jvm.monitor;

import com.sun.management.OperatingSystemMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.math.BigDecimal;
import java.math.MathContext;

public class JVMThread implements JVMThreadMBean {
    private static final Logger logger = LoggerFactory.getLogger(JVMThread.class);

    private static JVMThread instance = new JVMThread();

    private volatile long lastCPUTime;
    private volatile long lastCPUUpTime;

    private OperatingSystemMXBean operatingSystemMXBean;
    private RuntimeMXBean runtimeMXBean;
    private ThreadMXBean threadMXBean;
    private String blockedThreadInfo;
    private int maxStackTraceLength = 2000;

    public static JVMThread getInstance() {
        return JVMThread.instance;
    }

    private JVMThread() {
        this.threadMXBean = ManagementFactory.getThreadMXBean();
        this.runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        this.operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        try {
            this.lastCPUTime = this.operatingSystemMXBean.getProcessCpuTime();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    
    public int getDaemonThreadCount() {
        return this.threadMXBean.getDaemonThreadCount();
    }

    
    public int getThreadCount() {
        return this.threadMXBean.getThreadCount();
    }

    
    public long getTotalStartedThreadCount() {
        return this.threadMXBean.getTotalStartedThreadCount();
    }

    
    public int getDeadLockedThreadCount() {
//        return this.getDeadLockedThreadCount();
        try {
            long[] deadLockedThreadIds = this.threadMXBean.findDeadlockedThreads();
            if (deadLockedThreadIds == null) {
                return 0;
            }
            return deadLockedThreadIds.length;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    
    public String getDeadLockedThreadInfo() {
//        return this.getDeadLockedThreadInfo();
        StringBuilder stringBuilder = new StringBuilder();
        long[] deadLockedThreadIds = this.threadMXBean.findDeadlockedThreads();
        if (null != deadLockedThreadIds) {
            ThreadInfo[] threadInfos = this.threadMXBean.getThreadInfo(deadLockedThreadIds, true, true);
            for (int i = 0; i < threadInfos.length; i++) {
                if (i != 0) {
                    stringBuilder.append("\r\n");
                }
                stringBuilder.append(threadInfos[i].toString());
            }
        }
        String deadLockedThreadInfo = stringBuilder.toString();
        if (null != deadLockedThreadInfo && deadLockedThreadInfo.length() > this.maxStackTraceLength) {
            deadLockedThreadInfo = deadLockedThreadInfo.substring(0, this.maxStackTraceLength);
        }
        return deadLockedThreadInfo;
    }

    
    public String getBlockedThreadInfo() {
        if (null != this.blockedThreadInfo && this.blockedThreadInfo.length() > this.maxStackTraceLength) {
            this.blockedThreadInfo = this.blockedThreadInfo.substring(0, this.maxStackTraceLength);
        }
        return this.blockedThreadInfo;
    }

    
    public int getRunnableThreadCount() {
        return this.getThreadCountByState(Thread.State.RUNNABLE.name());
    }

    
    public int getNewThreadCount() {
        return this.getThreadCountByState(Thread.State.NEW.name());
    }

    
    public int getBlockedThreadCount() {
        return this.getThreadCountByState(Thread.State.BLOCKED.name());
    }

    
    public int getWaitingThreadCount() {
        return this.getThreadCountByState(Thread.State.WAITING.name());
    }

    
    public int getTimedWaitingThreadCount() {
        return this.getThreadCountByState(Thread.State.TIMED_WAITING.name());
    }

    
    public int getTerminatedThreadCount() {
        return this.getThreadCountByState(Thread.State.TERMINATED.name());
    }

    
    public BigDecimal getProcessCpuTimeRate() {
        long cupTime = this.operatingSystemMXBean.getProcessCpuTime();
        long upTime = this.runtimeMXBean.getUptime();

        long elapsedCpu = cupTime - this.lastCPUTime;
        long elapsedTime = upTime - this.lastCPUUpTime;

        this.lastCPUTime = cupTime;
        this.lastCPUUpTime = upTime;

        BigDecimal cpuRate;
        if (elapsedTime <= 0) {
            return new BigDecimal(0);
        }

        float cpuUsage = elapsedCpu / (elapsedTime * 10000F);
        cpuRate = new BigDecimal(cpuUsage, new MathContext(4));
        return cpuRate;
    }

    
    public String getPID() {
        return this.operatingSystemMXBean.getName().split("@")[0];
    }

    private int getThreadCountByState(String state) {
        ThreadInfo[] threadInfos = this.dumpAllThreads();
        return this.getThreadCountByState(threadInfos, state);
    }

    private int getThreadCountByState(ThreadInfo[] threadInfos, final String state) {
        StringBuilder blockedBuilder = new StringBuilder();
        int stateThreadCount = 0;
        for (ThreadInfo threadInfo : threadInfos) {
            if (threadInfo.getThreadState().name().equals(state)) {
                stateThreadCount++;
            }

            if (threadInfo.getThreadState().name().equals(Thread.State.BLOCKED.name())) {
                if (blockedBuilder.length() > 0) {
                    blockedBuilder.append("\r\n");
                }
                blockedBuilder.append(threadInfo.toString());
            }
        }
        this.blockedThreadInfo = blockedBuilder.toString();
        return stateThreadCount;
    }

    private ThreadInfo[] dumpAllThreads() {
        return this.threadMXBean.dumpAllThreads(false, false);
    }

    @Override
    public String toString() {
        return "JVMThread{" +
                "\nlastCPUTime=" + lastCPUTime +
                "\n, lastCPUUpTime=" + lastCPUUpTime +
                "\n, operatingSystemMXBean=" + operatingSystemMXBean +
                "\n, runtimeMXBean=" + runtimeMXBean +
                "\n, threadMXBean=" + threadMXBean +
                "\n, blockedThreadInfo='" + blockedThreadInfo + '\'' +
                "\n}";
    }
}
