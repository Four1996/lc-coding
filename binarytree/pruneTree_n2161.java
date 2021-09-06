package leetcode.binarytree;

/**
 * @program: first
 * @description: 二叉树剪枝
 * @author: panhao
 * @date: 2021-09-06 10:52
 **/
public class pruneTree_n2161 {
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

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        preOrder(root, null);
        if (root.right == null && root.left == null && root.val == 0) {
            root = null;
        }
        return root;
    }

    static void preOrder(TreeNode node, TreeNode parent) {
        if (node != null) {
            preOrder(node.left, node);
            preOrder(node.right, node);

            if (node.left == null && node.right == null && node.val == 0) {
                if (parent==null){
                    node=null;
                    return;
                }
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(pruneTree(node1));
    }

}
