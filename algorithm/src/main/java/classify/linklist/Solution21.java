package classify.linklist;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/10
 * @description:
 * 合并两个有序链表
 **/
public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode p = root;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int val2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (val1 > val2) {
                p.next = new ListNode(val2);
                l2 = l2.next;
            } else {
                p.next = new ListNode(val1);
                l1 = l1.next;
            }
            p = p.next;
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
