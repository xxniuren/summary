package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/10
 * @description: 头插法，每次都插到最头上
 **/
public class Solution92 {
    public static void main(String[] args) {
        Solution92 solution = new Solution92();
        ListNode head = solution.init();
        solution.reverseBetween(head, 2, 4);
    }

    public ListNode init() {
        ListNode curr = new ListNode(1);
        ListNode head = curr;
        for (int i = 2; i < 6; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            curr = curr.next;
        }
        ListNode future = curr.next;
        for (int i = m; i < n; i++) {
            curr.next = future.next;
            future.next = pre.next;
            pre.next = future;
            future = curr.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}
