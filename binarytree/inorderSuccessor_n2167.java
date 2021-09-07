package leetcode.binarytree;

/**
 * @program: first
 * @description: 二叉搜索树中的中序后继
 * @author: panhao
 * @date: 2021-09-06 21:25
 **/
public class inorderSuccessor_n2167 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode res = null;
    boolean tag = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorderSearch(root, p);
        return res;
    }

    void inorderSearch(TreeNode node, TreeNode p) {
        if (node != null && res == null) {
            inorderSearch(node.left, p);
            if (tag && res == null) {
                res = node;
                return;
            }
            if (node == p) {
                tag = true;
            }
            if (res == null) {
                inorderSearch(node.right, p);
            }
        }
    }
}
