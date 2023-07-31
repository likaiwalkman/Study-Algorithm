package leetcode.p380;

import java.util.*;

public class RandomizedSet {
    private List<Integer> array = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    private Random random = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            int size = array.size();
            array.add(val);
            map.put(val, size);
            return true;
        }else {
            return false;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Integer pos = map.get(val);
            int lastIndex = array.size() - 1;
            Integer last = array.get(lastIndex);
            array.set(pos, last);
            array.remove(lastIndex);
            map.put(last, pos);

            map.remove(val);
            return true;
        }else {
            return false;
        }
    }

    public int getRandom() {
        int i = random.nextInt(array.size());
        return array.get(i);
    }

    public static void main(String[] args) {

        ArrayList<Integer> ints = new ArrayList<>();
        ints.size();


        Integer i = 2;
        int j = 0;

        ints.add(2);
        ints.add(3);
        ints.remove(i);
        System.out.println(ints);

        ints.clear();
        ints.add(0);
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.remove(2);
        System.out.println(ints);

    }
}
