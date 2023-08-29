package leetcode.common;

import org.apache.commons.lang3.tuple.Pair;

import java.util.concurrent.Callable;

public class CallableTaskCostWatcher<V> {
    public CallableTaskCostWatcher(Callable<V> task) {
        this.task = task;
    }

    public Callable<V> task;
    public Pair<V, Long> timeCost(){
        if (task == null) {
            return Pair.of(null, -1L);
        }
        try {
            long start = System.currentTimeMillis();
            V callResult = task.call();
            long end = System.currentTimeMillis();
            return Pair.of(callResult, end - start);
        }catch (Exception e){
            return Pair.of(null, -1L);
        }
    }
}
