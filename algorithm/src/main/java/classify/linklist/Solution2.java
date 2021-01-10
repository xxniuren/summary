package classify.linklist;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/1/10
 * @description:
 **/
public class Solution2 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode root = new ListNode(0);
         ListNode p = root;
         int carr = 0;
         while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carr;
            carr = sum / 10;
            sum = sum % 10;
            ListNode next = new ListNode(sum);
            p.next = next;
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
         }
         if (carr != 0) {
             ListNode top = new ListNode(carr);
             p.next = top;
         }
         return root.next;
    }

}
