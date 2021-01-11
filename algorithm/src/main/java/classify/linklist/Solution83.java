package classify.linklist;

import java.awt.image.Kernel;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/30
 * @description:
 * 删除重复元素，每个元素只能出现一次
 **/
public class Solution83 {

    public static void main(String[] args) {
        Solution83 solution = new Solution83();
        ListNode head = solution.init();
        ListNode listNode = solution.deleteDuplicates(head);
        System.out.println("over");
    }

    public ListNode init() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        return head;
    }

    // 删除重复元素，每个元素只能出现一次
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode curr = root;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                ListNode tmp = curr.next;
                while (tmp.next != null && tmp.val == tmp.next.val) {
                    tmp = tmp.next;
                }
                curr.next = tmp;
            } else {
                curr = curr.next;
            }
        }
        return root.next;
    }

//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode point = dummy.next;
//        while (point != null && point.next != null) {
//            if (point.val == point.next.val) {
//                //这里查找出多少个重复的
//                ListNode tmp = point;
//                while (tmp.next != null && tmp.val == tmp.next.val) {
//                    tmp = tmp.next;
//                }
//                point.next = tmp.next;
//            }
//            point = point.next;
//        }
//        return dummy.next;
//    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
