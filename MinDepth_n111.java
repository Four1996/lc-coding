package leetcode;

/**
 * @author panhao
 * @date 2021年05月04日 2:30 下午
 */
public class MinDepth_n111 {
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

    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null&&root.right==null) return 1;
        int ans=Integer.MAX_VALUE;
        if (root.left!=null) ans=Math.min(minDepth(root.left),ans);
        if (root.right!=null) ans=Math.min(minDepth(root.right),ans);
        return ans+1;
    }
}
