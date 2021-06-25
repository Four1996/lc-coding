package leetcode.swordoffer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月20日 7:33 下午
 */
public class PathSum_n1939 {
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
    LinkedList<List<Integer>> ansList=new LinkedList<>();
      LinkedList<Integer> pathList=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return ansList;
    }
    void recur(TreeNode root,int target){
        if (root==null){
            return ;
        }
        pathList.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null) {
            ansList.add(new LinkedList<>(pathList));
        }
        recur(root.left,target);
        recur(root.right,target);
        pathList.removeLast();
    }
}
