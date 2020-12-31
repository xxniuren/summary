package classify.linklist;

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

    // 构建两个链表，串联起来则可
    public ListNode partition(ListNode head, int x) {
        ListNode ltHead = new ListNode(-1), gtHead = new ListNode(-1);
        ListNode ltPoint = ltHead, gtPoint = gtHead;
        ListNode point = head;
        while (point != null) {
            if (point.val >= x) {
                gtPoint.next = point;
                gtPoint = gtPoint.next;
            } else {
                ltPoint.next = point;
                ltPoint = ltPoint.next;
            }
            point = point.next;
        }
        ltPoint.next = gtHead.next;
        return ltHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode init() {
        ListNode head = new ListNode(5);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        return head;
    }

}
