package classify.linklist;

import java.util.List;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/12/29
 * @description:
 **/
public class Solution82 {

    public static void main(String[] args) {
        Solution82 solution = new Solution82();
        ListNode head = solution.init();
        ListNode listNode = solution.deleteDuplicates(head);
        System.out.println(listNode);
    }

    public ListNode init() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode curr = root;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                ListNode tmp = curr.next.next;
                while(tmp != null && tmp.next != null) {
                    if (tmp.val == tmp.next.val) {
                        tmp = tmp.next;
                    } else {
                        break;
                    }
                }
                curr.next = tmp.next;
            } else {
                curr = curr.next;
            }
        }
        return root.next;
    }

//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode root = new ListNode(-1);
//        root.next = head;
//        ListNode curr = root;
//
//        while (curr.next != null && curr.next.next != null) {
//            if (curr.next.val == curr.next.next.val) {
//                ListNode tmp = curr.next;
//                while (tmp.next != null && tmp.val == tmp.next.val) {
//                    tmp = tmp.next;
//                }
//                curr.next = tmp.next;
//            } else {
//                curr = curr.next;
//            }
//        }
//        return root.next;
//    }


//    /**
//     *
//     * 这个要画一下链表图，这个是重复的元素一次都不能出现
//     * @param head
//     * @return
//     */
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode curr = dummy;
//        while (curr.next != null && curr.next.next != null) {
//            // 找到重复的元素
//            if (curr.next.val == curr.next.next.val) {
//                ListNode tmp = curr.next;
//                while (curr.next != null && tmp.val == curr.next.val) {
//                    curr.next = curr.next.next;
//                }
//            } else { // 不存在重复的元素
//                curr = curr.next;
//            }
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
