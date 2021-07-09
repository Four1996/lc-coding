package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 填充每个节点的下一个右侧结点指针II
 * @author: panhao
 * @date: 2021-07-09 14:43
 **/
public class Connect_n117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        Node tail = root;
        Deque<Node> deque = new ArrayDeque<>();
        if (tail != null) deque.addFirst(tail);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                if (pre == null) pre = deque.pollLast();
                else {
                    pre.next = deque.peekLast();
                    pre = deque.pollLast();
                }
                if (pre.left != null) deque.addFirst(pre.left);
                if (pre.right != null) deque.addFirst(pre.right);
            }
        }
        return root;
    }
}
