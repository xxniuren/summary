package classify.linklist;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/10
 * @description:
 **/
public class Solution23 {

    //通过归并排序合并n个链表

//    public ListNode mergeKLists(ListNode[] lists) {
//        int left = 0;
//        int right = lists.length - 1;
//        if (right == 0) return null;
//        return merge(lists, left, right);
//    }
//
//    /**
//     * 归并排序
//     *
//     * @param lists
//     * @param left
//     * @param right
//     * @return
//     */
//    public ListNode merge(ListNode[] lists, int left, int right) {
//        if (left == right) return lists[left];
//        int mid = (left + right) / 2;
//        ListNode l1 = merge(lists, left, mid);
//        ListNode l2 = merge(lists, mid + 1, right);
//        return merge(l1, l2);
//    }




    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int left = 0;
        int right = lists.length - 1;
        return merge(lists, left, right);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode p = root;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int val2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            ListNode next = null;
            if (val1 > val2) {
                next = new ListNode(val2);
            } else {
                next = new ListNode(val1);
            }
            p.next = next;
            p = p.next;
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
