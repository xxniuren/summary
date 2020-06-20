package online;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2020/4/22
 * @description:
 **/
public class SwapPairs {

    public LinkNode swap(final LinkNode head) {
        if (null == head) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        LinkNode newHead = head.next;
        //先对第一个节点处理
        LinkNode previousNode = null;
        LinkNode pairOne = head;
        LinkNode pairTwo = head.next;
        //先做第一次反转，并赋值
        pairOne.next = pairTwo.next;
        pairTwo.next = pairOne;

        previousNode = pairOne;
        pairOne = pairOne.next;
        while (pairOne != null) {
            pairTwo = pairOne.next;
            if (null == pairTwo) {
                break;
            }
            previousNode.next = pairTwo;
            pairOne.next = pairTwo.next;
            pairTwo.next = pairOne;
            previousNode = pairOne;
            pairOne = pairOne.next;
        }
        return newHead;
    }


    public class LinkNode{
        public LinkNode (LinkNode next, int value) {
            this.next = next;
            this.value = value;
        }
        private int value;
        private LinkNode next;
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public LinkNode getNext() {
            return next;
        }
        public void setNext(LinkNode next) {
            this.next = next;
        }
    }
}
