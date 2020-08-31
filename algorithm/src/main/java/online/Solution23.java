package online;

import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/8/31
 * @description:
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表
 **/
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int left = 0;
        int right = lists.length - 1;
        if (lists.length == 0) return null;
        return merge(lists, left, right);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                point.next = node1;
                node1 = node1.next;
                point = point.next;
            } else {
                point.next = node2;
                node2 = node2.next;
                point = point.next;
            }
        }
        if (null == node1) {
            point.next = node2;
        } else {
            point.next = node1;
        }
        return head.next;
    }

    public ListNode[] init() {
        ListNode[] listNodes = new ListNode[3];
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        listNodes[0] = listNode1;

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        listNodes[1] = listNode2;

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        listNodes[2] = listNode3;

        return listNodes;
    }

    public static void main(String[] args) {
        Solution23 solution = new Solution23();
        ListNode[] listNodes = solution.init();
        ListNode listNode = solution.mergeKLists(listNodes);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
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
