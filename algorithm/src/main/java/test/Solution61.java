package test;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/14
 * @description:
 **/
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        // 边界条件
        if (head == null || head.next == null || k == 0) return head;
        // 获取链表长度
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        // 头尾节点串联形成环形链表，然后开始移动节点
        ListNode tail = curr;
        tail.next = head;
        curr = head;
        // 移动节点，找出新的头尾节点，然后将头尾断开则可。
        int mvCnt = len - k % len - 1;
        for (int i = 0; i < mvCnt; i++) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;
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
