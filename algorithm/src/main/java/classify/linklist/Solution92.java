package classify.linklist;

import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/2
 * @description:
 **/
public class Solution92 {
    public static void main(String[] args) {
        Solution92 solution = new Solution92();
        ListNode head = solution.init();
        ListNode listNode = solution.reverseBetween(head, 2, 4);
        System.out.println(listNode);
    }

    /**
     * pre 和 cur 不动，next一点点走
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head, next;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        next = cur.next;
        for (int i = m; i < n; i++) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
    }

    public ListNode init() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
