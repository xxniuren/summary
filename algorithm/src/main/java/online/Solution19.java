package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/29
 * @description: 删除链表的倒数第N个节点，给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 **/
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        //构建两个节点，节点之差为n，第二个节点走到最后一个
        ListNode faster = newHead;
        ListNode slower = newHead;
        for (int i = 0; i < n; i++) {
            faster = faster.next;
        }

        while (faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }
        slower.next = slower.next.next;

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
