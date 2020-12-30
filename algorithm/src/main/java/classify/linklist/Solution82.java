package classify.linklist;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/29
 * @description:
 **/
public class Solution82 {

    public static void main(String[] args) {

    }

    /**
     *
     * 这个要画一下链表图，这个是重复的元素一次都不能出现
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            // 找到重复的元素
            if (curr.next.val == curr.next.next.val) {
                ListNode tmp = curr.next;
                while (curr.next != null && tmp.val == curr.next.val) {
                    curr.next = curr.next.next;
                }
            } else { // 不存在重复的元素
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
