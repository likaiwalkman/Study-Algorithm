package jvm.monitor;

public interface JVMMemoryMBean {
    //Heap
    long getHeapMemoryCommitted();
    long getHeapMemoryInit();
    long getHeapMemoryMax();
    long getHeapMemoryUsed();

    //NonHeap
    long getNonHeapMemoryCommitted();
    long getNonHeapMemoryInit();
    long getNonHeapMemoryMax();
    long getNonHeapMemoryUsed();

    //PermGen
    long getPermGenCommitted();
    long getPermGenInit();
    long getPermGenMax();
    long getPermGenUsed();

    //OldGen
    long getOldGenCommitted();
    long getOldGenInit();
    long getOldGenMax();
    long getOldGenUsed();

    //EdenSpace
    long getEdenSpaceCommitted();
    long getEdenSpaceInit();
    long getEdenSpaceMax();
    long getEdenSpaceUsed();

    //survivor
    long getSurvivorCommitted();
    long getSurvivorInit();
    long getSurvivorMax();
    long getSurvivorUsed();

    String getPID();
}
