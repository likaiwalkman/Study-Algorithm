package jvm.monitor;

import jvm.monitor.util.JVMUtil;
import org.apache.commons.lang.StringUtils;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;
import java.util.Properties;

public class JVMInfo implements JVMInfoMBean {
    private static final int MAX_LIBRARY_PATH_LENGTH = 2000;
    private static JVMInfo instance = new JVMInfo();

    private RuntimeMXBean runtimeMXBean;
    private ClassLoadingMXBean classLoadingMXBean;
    private CompilationMXBean compilationMXBean;
    private Properties properties;
    private String inputArguments;
    private int availableProcessors = 0;

    public static JVMInfo getInstance() {
        return JVMInfo.instance;
    }

    private JVMInfo() {
        this.classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        this.compilationMXBean = ManagementFactory.getCompilationMXBean();
        this.runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        this.properties = System.getProperties();
    }

    private String getSystemProperty(String key) {
        return this.properties.getProperty(key);
    }

    @Override
    public Date getStartDate() {
        return new Date(this.runtimeMXBean.getStartTime());
    }

    @Override
    public String getJVM() {
        return this.runtimeMXBean.getVmName() + "(" + this.runtimeMXBean.getVmVersion() + "." + this.getSystemProperty("java.vm.info") + ")";
    }

    @Override
    public String getJavaVersion() {
        return this.getSystemProperty("java.version");
    }

    @Override
    public String getPID() {
        return JVMUtil.getPID();
    }

    @Override
    public String getInputArguments() {
        if (null == this.inputArguments) {
            this.inputArguments = this.runtimeMXBean.getInputArguments().toString();
        }
        return this.inputArguments;
    }

    @Override
    public String getJavaHome() {
        return this.getSystemProperty("java.home");
    }

    @Override
    public String getArch() {
        return this.getSystemProperty("os.arch");
    }

    @Override
    public String getOSName() {
        return this.getSystemProperty("os.name");
    }

    @Override
    public String getOSVersion() {
        return this.getSystemProperty("os.version");
    }

    @Override
    public String getVMVendor() {
        return this.getSystemProperty("java.vm.vendor");
    }

    @Override
    public String getSpecName() {
        return this.getSystemProperty("java.vm.specification.name");
    }

    @Override
    public String getSpecVendor() {
        return this.getSystemProperty("java.vm.specification.vendor");
    }

    @Override
    public String getJavaSpecificationVersion() {
        return this.getSystemProperty("java.specification.version");
    }

    @Override
    public String getJavaLibraryPath() {
        String javaLibraryPath = this.getSystemProperty("java.library.path");
        if (StringUtils.isNotBlank(javaLibraryPath) && javaLibraryPath.length() > JVMInfo.MAX_LIBRARY_PATH_LENGTH) {
            javaLibraryPath = javaLibraryPath.substring(0, JVMInfo.MAX_LIBRARY_PATH_LENGTH);
        }
        return javaLibraryPath;
    }

    @Override
    public String getManagementSpecVersion() {
        return this.runtimeMXBean.getManagementSpecVersion();
    }

    @Override
    public String getFileEncode() {
        return this.getSystemProperty("file.encoding");
    }

    @Override
    public String getClassPath() {
        return this.getSystemProperty("java.class.path");
    }

    @Override
    public String getBootClassPath() {
        return this.getSystemProperty("sun.boot.class.path");
    }

    @Override
    public int getAvailableProcessors() {
        if (this.availableProcessors == 0) {
            this.availableProcessors = Runtime.getRuntime().availableProcessors();
        }
        return this.availableProcessors;
    }

    @Override
    public int getLoadedClassCount() {
        return this.classLoadingMXBean.getLoadedClassCount();
    }

    @Override
    public long getTotalLoadedClassCount() {
        return this.classLoadingMXBean.getTotalLoadedClassCount();
    }

    @Override
    public long getUnloadedClassCount() {
        return this.classLoadingMXBean.getUnloadedClassCount();
    }

    @Override
    public String getJITCompilerName() {
        return this.compilationMXBean.getName();
    }

    @Override
    public long getTotalCompilationTime() {
        return this.compilationMXBean.getTotalCompilationTime();
    }
}
