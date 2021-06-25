package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author panhao
 * @date 2021年04月13日 10:05 上午
 */
public class MinDiffInBST_n783_2 {
  public static class TreeNode {
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
    static int min=Integer.MAX_VALUE;
    static TreeNode pre=null;
    public static int minDiffInBST(TreeNode root) {
      InOrder(root);
      return min;
    }
    static void InOrder(TreeNode root){
      if (root!=null){
          InOrder(root.left);
          if (pre!=null){
              min=Math.min(min,Math.abs(root.val-pre.val));
          }
          pre=root;
          InOrder(root.right);
      }
    }
    public static void main(String[] args) {
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(7);
        TreeNode node1=new TreeNode(5,node2,node3);
        System.out.println(minDiffInBST(node1));
    }
}
