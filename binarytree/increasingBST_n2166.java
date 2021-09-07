package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 展平二叉搜索树
 * @author: panhao
 * @date: 2021-09-06 21:16
 **/
public class increasingBST_n2166 {
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

    Deque<TreeNode> deque = new ArrayDeque<>();

    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = null;
        TreeNode tail = null;
        inorderBST(root);
        while (!deque.isEmpty()) {
            TreeNode node = new TreeNode(deque.pollLast().val);
            if (res == null) {
                res = tail = node;
            } else {
                tail.right = node;
                tail = node;
            }
        }
        return res;
    }

    void inorderBST(TreeNode node) {
        if (node != null) {
            inorderBST(node.left);
            deque.addFirst(node);
            inorderBST(node.right);
        }
    }
}
