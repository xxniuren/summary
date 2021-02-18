package classify.linklist;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/10
 * @description:
 **/
public class Solution23 {

    //也不是非得递归

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

    // 通过归并排序来做
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) return null;
        int left = 0, right = lists.length - 1;
        return merge(lists, left, right);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode root = new ListNode(-1);
        ListNode p = root;
        while (head1 != null || head2 != null) {
            int val1 = null == head1 ? Integer.MAX_VALUE : head1.val;
            int val2 = null == head2 ? Integer.MAX_VALUE : head2.val;
            if (val1 < val2) {
                p.next = new ListNode(val1);
                head1 = head1.next;
            } else {
                p.next = new ListNode(val2);
                head2 = head2.next;
            }
            p = p.next;
        }
        return root.next;
    }


//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) return null;
//        int left = 0;
//        int right = lists.length - 1;
//        return merge(lists, left, right);
//    }
//
//    public ListNode merge(ListNode[] lists, int left, int right) {
//        if (left == right) return lists[left];
//        int mid = (left + right) / 2;
//        ListNode l1 = merge(lists, left, mid);
//        ListNode l2 = merge(lists, mid + 1, right);
//        return merge(l1, l2);
//    }
//
//    public ListNode merge(ListNode l1, ListNode l2) {
//        ListNode root = new ListNode(-1);
//        ListNode p = root;
//        while (l1 != null || l2 != null) {
//            int val1 = l1 != null ? l1.val : Integer.MAX_VALUE;
//            int val2 = l2 != null ? l2.val : Integer.MAX_VALUE;
//            ListNode next = null;
//            if (val1 > val2) {
//                next = new ListNode(val2);
//            } else {
//                next = new ListNode(val1);
//            }
//            p.next = next;
//            p = p.next;
//        }
//        return root.next;
//    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
