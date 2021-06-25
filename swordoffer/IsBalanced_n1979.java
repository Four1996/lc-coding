package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月04日 9:31 下午
 */
public class IsBalanced_n1979 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root!=null){
            return getdepth(root)!=-1;
        }
        return true;
    }
    int getdepth(TreeNode root){
        if (root==null) return 0;
        int left=getdepth(root.left);
        if (left==-1) return -1;
        int right=getdepth(root.right);
        if (right==-1) return -1;
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}
