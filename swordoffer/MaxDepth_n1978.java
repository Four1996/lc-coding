package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月04日 9:16 下午
 */
public class MaxDepth_n1978 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

}
