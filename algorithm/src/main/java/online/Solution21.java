package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/29
 * @description:
 * 功能：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 **/
public class Solution21 {

    public static void main(String[] args) {
        Solution21 solution = new Solution21();
        ListNode l1 = solution.initL1();
        ListNode l2 = solution.initL2();
        solution.mergeTwoLists(l1, l2);
    }

    private ListNode initL1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        return head;
    }

    private ListNode initL2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }
        return newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
