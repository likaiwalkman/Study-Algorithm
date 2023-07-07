package leetcode.common;

public class ListNodeUtils {
    public static ListNode parse(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        ListNode root = new ListNode(arr[0]);
        ListNode head = root;
        for (int i = 1; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return root;
    }
}
