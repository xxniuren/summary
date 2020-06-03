
/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/6/2
 * @description:
 **/
public class Solution82 {

    public static void main(String[] args) {
        Solution82 solution = new Solution82();
        ListNode head = solution.init();
        solution.deleteDuplicates(head);
    }

    /**
     * 功能：初始化
     * @return
     */
    public ListNode init() {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        int[] arr = new int[]{1,2,3,3,4,4,5};
        for(int a : arr) {
            ListNode ln = new ListNode(a);
            point.next = ln;
            point = point.next;
        }
        point.next = null;
        return head.next;
    }

    /**
     * 功能：删除重复节点
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                ListNode tmp = curr.next;
                while (curr.next != null && curr.next.val == tmp.val) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }


    /**
     * 链路节点
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
