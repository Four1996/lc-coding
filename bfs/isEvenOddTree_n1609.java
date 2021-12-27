package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 奇偶树
 * @author: panhao
 * @date: 2021-12-27 20:06
 **/
public class isEvenOddTree_n1609 {
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

    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean odd = false;
        if (root != null) {
            deque.addLast(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            int pre = -1;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                int num = treeNode.val;
                if (odd) {
                    if (i == 0) {
                        if (num % 2 != 0) {
                            return false;
                        }
                        pre = num;
                    } else {
                        if (num % 2 != 0 || num >= pre) {
                            return false;
                        } else {
                            pre = num;
                        }
                    }
                } else {
                    if (i == 0) {
                        if (num % 2 == 0) {
                            return false;
                        }
                        pre = num;
                    } else {
                        if (num % 2 == 0 || num <= pre) {
                            return false;
                        } else {
                            pre = num;
                        }
                    }
                }
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
            if (odd) {
                odd = false;
            } else {
                odd = true;
            }
        }
        return true;
    }
}
