package leetcode;

import com.sun.source.tree.IfTree;

/**
 * @author panhao
 * @date 2021年05月04日 2:01 下午
 */
public class IsBalanced_n110 {
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

    public boolean isBalanced(TreeNode root) {

        if (root!=null){
            return Math.abs(getdepth(root.left)-getdepth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
        return true;

    }
    int getdepth(TreeNode root){
        if (root==null) return 0;
        return Math.max(getdepth(root.left),getdepth(root.right))+1;
    }
}
