package jvm.monitor;

import java.math.BigDecimal;

public interface JVMThreadMBean {
    int getDaemonThreadCount();
    int getThreadCount();
    long getTotalStartedThreadCount();
    int getDeadLockedThreadCount();
    String getDeadLockedThreadInfo();
    String getBlockedThreadInfo();
    int getRunnableThreadCount();
    int getNewThreadCount();
    int getBlockedThreadCount();
    int getWaitingThreadCount();
    int getTimedWaitingThreadCount();
    int getTerminatedThreadCount();
    BigDecimal getProcessCpuTimeRate();
    String getPID();
}
