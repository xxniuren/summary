package classify.linklist;

import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/10
 * @description:
 **/
public class Solution25 {

    public static void main(String[] args) {
        Solution25 solution = new Solution25();
        ListNode head = solution.init();
        ListNode listNode = solution.reverseKGroup(head, 3);
        System.out.println(listNode);
    }


    public ListNode init() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        return root;
    }

    /**
     * 按照k一组反转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) return null;
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if (p == null) return root.next;
            p = p.next;
        }
        ListNode pre = root, curr = root.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode next = curr.next;
            ListNode tmp = next.next;
            next.next = pre.next;
            pre.next = next;
            curr.next = tmp;
        }
        head.next = reverseKGroup(curr.next, k);
        return root.next;
    }
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode root = new ListNode(-1);
//        root.next = head;
//        ListNode p = root;
//        int cnt = 0;
//        while (p != null && cnt < k) {
//            p = p.next;
//            cnt++;
//        }
//        if (cnt < k) return head;
//        ListNode curr = head.next;
//        ListNode next = curr.next;
//        for (int i = 0; i < k; i++) {
//            ListNode tmp = next.next;
//            next.next = head.next;
//            head.next = next;
//            curr.next = tmp;
//            next = curr.next;
//        }
//        head.next = reverseKGroup(curr, k);
//        return null;
//    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
