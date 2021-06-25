package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月20日 8:13 下午
 */
public class PathSum_n113 {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        recur(root,targetSum);
        return ansList;
    }
    void recur(TreeNode root,int tar){
        if (root==null) return;
        pathList.addLast(root.val);
        tar-=root.val;
        if (tar==0&&root.left==null&&root.right==null) ansList.addLast(new LinkedList<>(pathList));
        recur(root.left,tar);
        recur(root.right,tar);
        pathList.removeLast();
    }
}
