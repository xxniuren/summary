/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/5/26
 * @description: 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 * 先计算链表长度，然后把链表做成环，然后找到第k的位置，然后把
 * 1 - 2 - 3 - 4
 * 移动3格，1 -> 2 -> 3 -> 4
 * 2 -> 3 -> 4 -> 1
 **/
public class Solution61 {
    public static void main(String[] args) {
        Solution61 solution = new Solution61();
        ListNode head = solution.initNode();
        solution.rotateRight(head, 2);
    }

    public ListNode initNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode cursor = head;
        ListNode tail = null;
        int len = 1;
        while (cursor.next != null) {
            cursor = cursor.next;
            len++;
        }
        tail = cursor;
        tail.next = head;
        cursor = head;
        int loop = len - k % len - 1;
        for (int i = 0; i < loop; i++) {
            cursor = cursor.next;
        }
        head = cursor.next;
        cursor.next = null;
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
