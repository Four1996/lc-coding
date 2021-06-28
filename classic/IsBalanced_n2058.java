package leetcode.classic;

/**
 * @program: first
 * @description: 检查平衡性
 * @author: panhao
 * @date: 2021-06-28 19:23
 **/
public class IsBalanced_n2058 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else {
            return Math.abs(getDepth(root.left) - getDepth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
        }
    }
}
