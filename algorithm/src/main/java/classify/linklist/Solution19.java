package classify.linklist;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/10
 * @description:
 **/
public class Solution19 {
    /**
     * 查找倒数第n个，构建两个链表，一个走快n步，然后一起走，知道快节点到尾点，
     * 这样可以拿到倒数第n个节点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode fast = root, slow = root;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return root.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
