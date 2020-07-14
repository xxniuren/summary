package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/7/13
 * @description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * (2 -> 4 -> 3) + (5 -> 6 -> 4) -> 7 -> 0 -> 8
 **/
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode l1 = solution.initL1();
        ListNode l2 = solution.initL2();
        ListNode head = solution.addTwoNumbers(l1, l2);
        System.out.println(head);
    }

    public ListNode initL1() {
       ListNode head = new ListNode(9);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        return head;
    }


    public ListNode initL2() {
        ListNode head = new ListNode(5);
        head.next = new ListNode(6);
        head.next.next = new ListNode(4);
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) return null;
        long sum1 = null == l1 ? 0 : getSum(l1);
        long sum2 = null == l2 ? 0 : getSum(l2);
        long sum = sum1 + sum2;
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while (sum / 10 > 0) {
            int rem = (int)sum % 10;
            sum /= 10;
            point.next = new ListNode(rem);
            point = point.next;
        }
        point.next = new ListNode((int)sum);
        return head.next;
    }

    public int getSum(ListNode listNode) {
        int pos = 1;
        int sum = 0;
        while (listNode != null) {
            sum += listNode.val * pos;
            listNode = listNode.next;
            pos = pos * 10;
        }
        return sum;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
