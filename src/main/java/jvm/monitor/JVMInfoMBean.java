package jvm.monitor;

import java.util.Date;

public interface JVMInfoMBean {
    Date getStartDate();
    String getJVM();
    String getJavaVersion();
    String getPID();
    String getInputArguments();
    String getJavaHome();
    String getArch();
    String getOSName();
    String getOSVersion();
    String getVMVendor();
    String getSpecName();
    String getSpecVendor();
    String getJavaSpecificationVersion();
    String getJavaLibraryPath();
    String getManagementSpecVersion();
    String getFileEncode();
    String getClassPath();
    String getBootClassPath();
    int getAvailableProcessors();
    int getLoadedClassCount();
    long getTotalLoadedClassCount();
    long getUnloadedClassCount();
    String getJITCompilerName();
    long getTotalCompilationTime();
}
