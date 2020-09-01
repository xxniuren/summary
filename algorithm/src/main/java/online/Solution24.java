package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/9/1
 * @description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换；
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 三指针，
 **/
public class Solution24 {

    public static void main(String[] args) {
        Solution24 solution = new Solution24();
        ListNode head = solution.init();
        ListNode convertHead = solution.swapPairs(head);
    }

    public ListNode init() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        return head;
    }

    public ListNode swapPairs(ListNode head) {
       ListNode first = new ListNode(-1);
       first.next = head;
       ListNode fp =  first;
       ListNode sp = null;
       ListNode tp = null;
       while (fp.next != null && fp.next.next != null) {
           sp = fp.next;
           tp = sp.next;

           sp.next = tp.next;
           tp.next = sp;
           fp.next = tp;
           fp = sp;
       }
       return first.next;
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
