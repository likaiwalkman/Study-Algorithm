package leetcode.p933;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecentCounter {

    private List<Integer> list = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        list.add(t);
        int leftBorder = t - 3000;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < leftBorder) {
                iterator.remove();
            }else {
                break;
            }
        }

        return list.size();

    }
}
