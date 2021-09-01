package leetcode.linkedList;

/**
 * @program: first
 * @description: 展开多级双向链表
 * @author: panhao
 * @date: 2021-09-01 16:16
 **/
public class Flatten_n2132 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node tail = head;
        while (tail != null) {
            if (tail.child != null) {
                Node c = tail.child;
                Node next = tail.next;
                tail.next = c;
                tail.child = null;
                c.prev = tail;
                while (c.next != null) {
                    c = c.next;
                }
                c.next = next;
                if (next != null) {
                    next.prev = c;
                }
            }
            tail = tail.next;
        }
        return head;
    }
}
