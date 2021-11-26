package leetcode.binarytree;

/**
 * @program: first
 * @description: 二叉搜索树中的搜索
 * @author: panhao
 * @date: 2021-11-26 21:53
 **/
public class searchBST_n700 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else {
            if (val > root.val) {
                return searchBST(root.right, val);
            } else if (val < root.val) {
                return searchBST(root.left, val);
            } else {
                return root;
            }
        }
    }
}
