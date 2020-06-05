/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/5
 * @description: 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置
 **/
public class Solution86 {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode ltNode = new ListNode(0);
        ListNode gtNode = new ListNode(0);
        ListNode ltPoint = ltNode;
        ListNode gtPoint = gtNode;
        while (head != null) {
            if (head.val < x) {
                ltPoint.next = head;
                head = head.next;
                ltPoint = ltPoint.next;
                ltPoint.next = null;
            } else {
                gtPoint.next = head;
                head = head.next;
                gtPoint = gtPoint.next;
                gtPoint.next = null;
            }
        }
        ltPoint.next = gtNode.next;
        return ltNode.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
