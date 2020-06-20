package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/3
 * @description:
 **/
public class Solution83 {
    public static void main(String[] args) {
        Solution83 solution = new Solution83();
        ListNode head = solution.init();
        solution.deleteDuplicates(head);
    }

    /**
     * 功能：通过递归来处理
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) head = head.next;
        return head;
    }

    /**
     * 功能：初始化
     *
     * @return
     */
    public ListNode init() {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        int[] arr = new int[]{1, 2, 3, 3, 4, 4, 5};
        for (int a : arr) {
            ListNode ln = new ListNode(a);
            point.next = ln;
            point = point.next;
        }
        point.next = null;
        return head.next;

    }

    /**
     * 链路节点
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
