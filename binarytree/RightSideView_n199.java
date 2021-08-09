package leetcode.binarytree;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.*;

/**
 * @program: first
 * @description: 二叉树的右视图
 * @author: panhao
 * @date: 2021-08-09 16:28
 **/
public class RightSideView_n199 {
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.add(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollLast();
                if (i == size - 1) {
                    ans.add(node.val);
                }
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
            }
        }
        return ans;
    }
}
