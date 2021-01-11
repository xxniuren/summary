package classify.linklist;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/10
 * @description:
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
 **/
public class Solution61 {

    public static void main(String[] args) {
        Solution61 solution = new Solution61();
        ListNode head = solution.init();
        ListNode listNode = solution.rotateRight(head, 2);
        System.out.println(listNode.toString());
    }

    public ListNode init() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    /**
     * 1. 将链表串为环链表，然后走 len - (k % cnt) - 1步骤；
     * 2. 处理链表
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode p = head;
        int cnt = 0;
        while (p.next != null) {
            // 找到尾节点
            p = p.next;
            cnt++;
        }
        cnt++;
        p.next = head;
        int mvCnt = cnt - (k % cnt);
        for (int i = 0; i < mvCnt - 1; i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
