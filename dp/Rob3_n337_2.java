package leetcode.dp;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年06月14日 2:55 下午
 */
public class Rob3_n337_2 {
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

    public int rob(TreeNode root) {
        int[] res=getMax(root);
        return Math.max(res[0],res[1]);
    }
    public int[] getMax(TreeNode root){
        if (root==null) return new int[2];
        int[] res=new int[2];
        int[] left=getMax(root.left);
        int[] right=getMax(root.right);
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=left[0]+right[0]+root.val;
        return res;
    }
}
