package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/10
 * @description:
 **/
public class Solution109 {

    public static void main(String[] args) {
        Solution109 solution = new Solution109();
        ListNode head = solution.init();
        TreeNode root = solution.sortedListToBST(head);
        System.out.println(root.val);
    }

    //-10, -3, 0, 5, 9
    public ListNode init() {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        return head;
    }

    public TreeNode sortedListToBST(ListNode head) {
        //核心思想：找到链表的中点
        if (null == head) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = head.next;
        ListNode q = p.next;
        while (q != null && q.next != null) {
            pre = pre.next;
            p = p.next;
            q = q.next.next;
        }
        //中间节点断开
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }

    /**
     * 链表节点
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 树节点
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
