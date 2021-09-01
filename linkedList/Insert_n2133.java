package leetcode.linkedList;

/**
 * @program: first
 * @description: 排序的循环链表
 * @author: panhao
 * @date: 2021-09-01 17:49
 **/
public class Insert_n2133 {
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public static Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        if (head == null) {
            n.next = n;
            return n;
        }
        Node tail = head;
        while (true) {
            if (tail.next == head || tail.val <= insertVal && insertVal <= tail.next.val || tail.val > tail.next.val &&
                    (tail.val <= insertVal || tail.next.val >= insertVal)) {
                n.next = tail.next;
                tail.next = n;
                break;
            }
            tail = tail.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(insert(node1, 0));
    }
}
