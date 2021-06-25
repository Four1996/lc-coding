package leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年04月25日 9:22 上午
 */
public class IncreasingBST_897 {
    public static class TreeNode {
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
    Queue<TreeNode> queue = new ArrayDeque<>();
    public TreeNode increasingBST(TreeNode root) {
        if (root != null) inorderSearch(root);
        TreeNode newroot = null;
        TreeNode tail = null;
        while (!queue.isEmpty()) {
            TreeNode node = new TreeNode(queue.poll().val);
            if (newroot == null) newroot = tail = node;
            else {
                tail.right = node;
                tail = node;
            }
        }
        return newroot;
    }
    public void inorderSearch(TreeNode root) {
        if (root != null) {
            inorderSearch(root.left);
            queue.add(root);
            inorderSearch(root.right);
        }
    }
    public static void main(String[] args) {
        IncreasingBST_897 increasingBST_897 = new IncreasingBST_897();
        TreeNode node = new TreeNode(212);
        increasingBST_897.increasingBST(node);
    }
}