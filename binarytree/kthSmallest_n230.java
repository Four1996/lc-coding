package leetcode.binarytree;

/**
 * @program: first
 * @description: 二叉搜索树中第K小的元素
 * @author: panhao
 * @date: 2021-10-17 19:01
 **/
public class kthSmallest_n230 {
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

    int count;
    TreeNode ans;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root, k);
        return ans.val;
    }

    public void dfs(TreeNode root, int k) {
        if (root != null && count > 0) {
            dfs(root.left, k);
            count--;
            if (count == 0) {
                ans = root;
                return;
            }
            dfs(root.right, k);
        }
    }

}
