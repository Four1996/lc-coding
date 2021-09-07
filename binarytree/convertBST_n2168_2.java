package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: first
 * @description: 所有大于等于节点的值之和
 * @author: panhao
 * @date: 2021-09-06 21:45
 **/
public class convertBST_n2168_2 {
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


    int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        inorderSearch(root);
        return root;
    }

    void inorderSearch(TreeNode node) {
        if (node != null) {
            inorderSearch(node.right);
            sum += node.val;
            node.val = sum;
            inorderSearch(node.left);
        }
    }
}
