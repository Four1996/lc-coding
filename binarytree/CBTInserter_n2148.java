package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;

/**
 * @program: first
 * @description: 往完全二叉树添加节点
 * @author: panhao
 * @date: 2021-09-04 15:09
 **/
public class CBTInserter_n2148 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Deque<TreeNode> deque;
    TreeNode root;

    public CBTInserter_n2148(TreeNode root) {
        deque = new ArrayDeque<>();
        if (root != null) {
            deque.addFirst(root);
            boolean tag = false;
            while (!deque.isEmpty() && !tag) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.peekLast();
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null && node.right != null) {
                        deque.pollLast();
                    } else {
                        tag = true;
                        break;
                    }
                }
            }
        }
        this.root = root;
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode parent = deque.peekLast();
        if (parent.left == null) {
            parent.left = node;
        } else if (parent.right == null) {
            parent.right = node;
            deque.pollLast();
        }
        deque.addFirst(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
