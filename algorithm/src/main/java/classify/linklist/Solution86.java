package classify.linklist;

import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/31
 * @description:
 * 分隔链表
 **/
public class Solution86 {

    public static void main(String[] args) {
        Solution86 solution = new Solution86();
        ListNode head = solution.init();
        ListNode partition = solution.partition(head, 3);
        System.out.println("xxx" + partition);

    }

    public ListNode partition(ListNode head, int x) {
        ListNode ltHead = new ListNode(-1);
        ListNode gtHead = new ListNode(-1);
        ListNode gtCurr = gtHead, ltCurr = ltHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val >= x) {
                gtCurr.next = curr;
                gtCurr = gtCurr.next;
            } else {
                ltCurr.next = curr;
                ltCurr = ltCurr.next;
            }
            curr = curr.next;
        }
        gtCurr.next = null;
        ltCurr.next = gtHead.next;
        return ltHead.next;
    }


//    // 构建两个链表，串联起来则可
//    public ListNode partition(ListNode head, int x) {
//        ListNode ltHead = new ListNode(-1), gtHead = new ListNode(-1);
//        ListNode ltPoint = ltHead, gtPoint = gtHead;
//        ListNode point = head;
//        while (point != null) {
//            if (point.val >= x) {
//                gtPoint.next = point;
//                gtPoint = gtPoint.next;
//            } else {
//                ltPoint.next = point;
//                ltPoint = ltPoint.next;
//            }
//            point = point.next;
//        }
//        ltPoint.next = gtHead.next;
//        return ltHead.next;
//    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode init() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        return head;
    }

}
