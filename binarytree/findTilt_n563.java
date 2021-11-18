package leetcode.binarytree;

/**
 * @program: first
 * @description: 二叉树的坡度
 * @author: panhao
 * @date: 2021-11-18 14:03
 **/
public class findTilt_n563 {
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

    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root != null) {
            int left = dfs(root.left);
            int right = dfs(root.right);
            ans += Math.abs(left - right);
            return left + right + root.val;
        }
        return 0;
    }
}
