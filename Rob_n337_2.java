package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月27日 3:56 下午
 */
public class Rob_n337_2 {
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

    public static int rob(TreeNode root) {
        int[] res=robInternal(root);
        return Math.max(res[0],res[1]);
    }

    public static int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        int[] res=new int[2];
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=left[0]+right[0]+root.val;
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        System.out.println(rob(node));
    }
}
