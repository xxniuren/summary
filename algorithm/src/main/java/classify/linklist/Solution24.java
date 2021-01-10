package classify.linklist;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/10
 * @description:
 **/
public class Solution24 {

    /**
     * 两个节点反转
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode p = root;
        while (p.next != null && p.next.next != null) {
            ListNode l1 = p.next;
            ListNode l2 = l1.next;
            ListNode l3 = l2.next;
            p.next = l2;
            l2.next = l1;
            l1.next = l3;
            p = l1;
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
