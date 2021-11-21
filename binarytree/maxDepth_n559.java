package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @program: first
 * @description: N叉树的最大深度
 * @author: panhao
 * @date: 2021-11-21 16:50
 **/
public class maxDepth_n559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        int h = 0;
        Deque<Node> deque = new ArrayDeque<>();
        if (root==null) {
            return 0;
        }
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            h++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.pollLast();
                List<Node> list = node.children;
                for (Node value : list) {
                    deque.addFirst(value);
                }
            }
        }
        return h;
    }


}
