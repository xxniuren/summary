import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/7
 * @description:
 **/
public class BlackTrackingLinkNode {
    public class Node {
        Node next;
        String value;
    }
    public void blackTrackingLinkNode(Node head) {
        Stack stack = new Stack();
        while (head.next != null) {
            stack.push(head.value);
            head = head.next;
        }
        stack.push(head.value);
    }
}
