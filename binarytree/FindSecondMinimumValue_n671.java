package leetcode.binarytree;

/**
 * @program: first
 * @description: 二叉树中第二小的节点
 * @author: panhao
 * @date: 2021-07-27 16:00
 **/
public class FindSecondMinimumValue_n671 {
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


    static int ans=-1;
    static int root_val;
    public static int findSecondMinimumValue(TreeNode root) {
        root_val =root.val;
        dfs(root);
        return ans;
    }

    static void dfs(TreeNode root) {
        if (root==null) return;
        if (ans!=-1&&root.val>=ans) return;
        if (root.val> root_val) ans=root.val;
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        TreeNode r1=new TreeNode(2);
        TreeNode r2=new TreeNode(2);
        // TreeNode r3=new TreeNode(5);
        // TreeNode r4=new TreeNode(7);
        root.left=r1;
        root.right=r2;
        // root.left=r3;
        // root.right=r4;
        System.out.println(findSecondMinimumValue(root));
    }
}
