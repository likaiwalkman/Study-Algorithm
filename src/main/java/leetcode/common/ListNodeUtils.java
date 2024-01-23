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
    public static String convertNonCyclicListNodeToString(ListNode listNode){
        StringBuilder builder = new StringBuilder();
        while (listNode != null){
            if (listNode.next != null) {
                builder.append(listNode.val).append("->");
            }else {
                builder.append(listNode.val);
            }
            listNode = listNode.next;
        }
        return builder.toString();
    }
}
