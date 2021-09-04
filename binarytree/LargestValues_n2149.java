package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: first
 * @description: 二叉树每层的最大值
 * @author: panhao
 * @date: 2021-09-04 15:37
 **/
public class LargestValues_n2149 {
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

    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.addFirst(root);
        }
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollLast();
                max = Math.max(treeNode.val, max);
                if (treeNode.left != null) {
                    deque.addFirst(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addFirst(treeNode.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
