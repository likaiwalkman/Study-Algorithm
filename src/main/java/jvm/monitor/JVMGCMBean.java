package jvm.monitor;

import java.math.BigDecimal;

public interface JVMGCMBean {
    long getYoungGCCollectionCount();
    long getYoungGCCollectionTime();

    long getFullGCCollectionCount();
    long getFullGCCollectionTime();

    long getSpanYoungGCCollectionCount();
    long getSpanYoungGCCollectionTime();

    long getSpanFullGCCollectionCount();
    long getSpanFullGCCollectionTime();

    BigDecimal getFullGCCollectionTimeRate();
}
