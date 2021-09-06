package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 从根节点到叶结点的路径数字之和
 * @author: panhao
 * @date: 2021-09-06 16:18
 **/
public class sumNumbers_n2163 {
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

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        int num = 0;
        if (root != null) {
            dfs(root, num + root.val);
        }
        return sum;
    }

    void dfs(TreeNode node, int num) {
        if (node.left == null && node.right == null) {
            sum += num;
            return;
        }
        if (node.left != null) {
            dfs(node.left, num * 10 + node.left.val);
        }
        if (node.right != null) {
            dfs(node.right, num * 10 + node.right.val);
        }
    }

}
