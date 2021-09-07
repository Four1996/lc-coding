package leetcode.binarytree;

/**
 * @program: first
 * @description: 结点之和最大的路径
 * @author: panhao
 * @date: 2021-09-06 20:45
 **/
public class maxPathSum_n2165 {
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

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);

        int cur = left + right + node.val;
        ans = Math.max(cur, ans);
        return node.val + Math.max(left, right);
    }

}
