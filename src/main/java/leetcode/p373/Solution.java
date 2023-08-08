package leetcode.p373;

import java.util.*;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> minRootHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if ( nums1[o1.get(0)] + nums2[o1.get(1)] > nums1[o2.get(0)] + nums2[o2.get(1)] ){
                    return 1;
                }else if (nums1[o1.get(0)] + nums2[o1.get(1)] == nums1[o2.get(0)] + nums2[o2.get(1)]){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        Set<List<Integer>> visitedSet = new HashSet<>();
        int k1 = k;
        for (int i = 0; i < nums1.length; i++) {
            if (k1 == 0) {
                break;
            }
            for (int j = 0; j < nums2.length; j++) {
                if (k1 == 0) {
                    break;
                }
                List<Integer> item = new ArrayList<>();
                item.add(i);
                item.add(j);
                visitedSet.add(item);
                System.out.println("item1: "+ item);
                minRootHeap.offer(item);
                k1--;
            }
        }
        int k2 = k;
        for (int i = 0; i < nums2.length; i++) {
            if (k2 == 0) {
                break;
            }
            for (int j = 0; j < nums1.length; j++) {
                if (k2 == 0) {
                    break;
                }
                List<Integer> item = new ArrayList<>();
                item.add(j);
                item.add(i);
                if (!visitedSet.contains(item)) {
                    List<Integer> peek = minRootHeap.peek();
//                    if (nums1[j] + nums2[i] < nums1[peek.get(0)] + nums2[peek.get(1)]) {
//                        System.out.println("item2 new: "+ item);
//                        visitedSet.add(item);
//                        minRootHeap.poll();
//
//                    }
                    minRootHeap.offer(item);
                }else {
                    System.out.println("item2 filter: "+ item);
                }
                k2--;
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (k > 0 && !minRootHeap.isEmpty()){
            List<Integer> poll = minRootHeap.poll();
            System.out.println("poll:"+poll);
            List<Integer> item = new ArrayList<>();
            item.add(nums1[poll.get(0)]);
            item.add(nums2[poll.get(1)]);
            result.add(item);
            k--;
        }
        return result;
    }
}
