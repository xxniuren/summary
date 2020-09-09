package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/9/2
 * @description:
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 该题多看几遍
 *
 **/
public class Solution25 {


    public static void main(String[] args) {
        Solution25 solution = new Solution25();
        ListNode head = solution.initLink();
        ListNode newHead = solution.reverseKNGroup(head, 3);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    /**
     *
     * 功能：初始化Link
     * @return
     */
    public ListNode initLink() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        return head;
    }

    /**
     * 功能：将List按照K进行反转
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKNGroup(ListNode head, int k) {
        if (null == head) {
            return null;
        }

        int count = 0;
        ListNode temp = head;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        if (count < k) return head;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != temp) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverseKNGroup(temp, k);
        return prev;
    }






















    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode tmp = head;
        while (tmp != null && count < k) {
            tmp = tmp.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;
        while (cur != tmp) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next =  reverseKGroup(tmp, k);
        return prev;
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