package leetcode.swordoffer;

import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月25日 10:38 上午
 */
public class TreeToDoublyList_n1946_2 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    public Node treeToDoublyList(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p;
        Node head = null, pre = null;
        if (root == null) return null;
        else {
            p = root;
        }
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (pre != null) pre.right = p;
                else head = p;
                p.left = pre;
                pre = p;
                p = p.right;
            }
        }
        head.left = pre;
        pre.right = head;
        return head;
    }

}
