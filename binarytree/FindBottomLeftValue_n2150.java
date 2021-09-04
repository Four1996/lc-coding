package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 二叉树最底层最左边的值
 * @author: panhao
 * @date: 2021-09-04 15:43
 **/
public class FindBottomLeftValue_n2150 {
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

    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.addFirst(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollLast();
                if (i == 0) {
                    ans = treeNode.val;
                }
                if (treeNode.left != null) {
                    deque.addFirst(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addFirst(treeNode.right);
                }
            }
        }
        return ans;
    }
}
