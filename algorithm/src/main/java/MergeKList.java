import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/21
 * @description:
 **/
public class MergeKList {

    public ListNode solution(ListNode[] listNodes) {
        final PriorityQueue<ListNode> queue = new PriorityQueue((Comparator<ListNode>) (o1, o2) -> o1.getVal() - o2.getVal());
        List<ListNode> nodes = Arrays.asList(listNodes);
        nodes.forEach(t -> {
            while (t != null) {
                queue.add(t);
                t = t.next;
            }
        });
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        while (!queue.isEmpty()) {
            tmp.next = queue.poll();
            tmp = tmp.next;
        }
        tmp.next = null;
        return head.next;
    }


    public class ListNode {
        int val;

        public int getVal() {
            return val;
        }

        ListNode next;
        ListNode(int x) { val = x; }
    }
}
