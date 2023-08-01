package leetcode.p148;

import leetcode.common.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode head0 = head;
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }

        ListNode listNode = sortList(head0, 0, len-1);
        return listNode;
    }

    public ListNode sortList(ListNode head, int start, int end){
        if (start == end){
            return head;
        }
        int mid = (start+end) / 2;
        ListNode midNode = head;
        int start0 = start;
        while (start0 != mid){
            midNode = midNode.next;
            start0++;
        }
        ListNode midNextNode = midNode.next;
        midNode.next = null;
        ListNode leftSortedListNode = sortList(head, start, mid);
        ListNode rightSortedListNode = null;
        if (midNextNode != null){
            rightSortedListNode = sortList(midNextNode, mid+1, end);
        }
        if (rightSortedListNode == null) {
            return leftSortedListNode;
        }else {
            ListNode result0 = null;
            ListNode result = null;
            while (leftSortedListNode != null || rightSortedListNode!=null){
                ListNode item = null;
                if (leftSortedListNode != null && rightSortedListNode == null){
                    item = leftSortedListNode;
                    leftSortedListNode = leftSortedListNode.next;
                }else if (rightSortedListNode != null && leftSortedListNode == null){
                    item = rightSortedListNode;
                    rightSortedListNode = rightSortedListNode.next;
                }else {
                    if (leftSortedListNode.val < rightSortedListNode.val){
                        item = leftSortedListNode;
                        leftSortedListNode = leftSortedListNode.next;
                    }else {
                        item = rightSortedListNode;
                        rightSortedListNode = rightSortedListNode.next;
                    }
                }
                if (result0 == null){
                    result0 = item;
                }
                if (result == null){
                    result = item;
                }else {
                    result.next = item;
                    result = item;
                }
            }
            return result0;
        }

    }
}
