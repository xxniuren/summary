package classify.linklist;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/10
 * @description:
 **/
public class Solution25 {
    /**
     * 按照k一组反转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode p = root;
        int cnt = 0;
        while (p != null && cnt < k) {
            p = p.next;
            cnt++;
        }
        if (cnt < k) return head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        for (int i = 0; i < k; i++) {
            ListNode tmp = next.next;
            next.next = head.next;
            head.next = next;
            curr.next = tmp;
            next = curr.next;
        }
        head.next = reverseKGroup(curr, k);
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
