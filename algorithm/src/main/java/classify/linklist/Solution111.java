package classify.linklist;


/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/31
 * @description: 链表反转
 * 双指针处理，头插法
 **/
public class Solution111 {

    public static void main(String[] args) {
        Solution111 solution = new Solution111();
        ListNode head = solution.init();
        ListNode reverse = solution.reverse(head);
        System.out.println("xx" + reverse);
    }

    public ListNode init() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        return head;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = curr;
            curr = next;
            next = tmp;
        }
        return curr;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
