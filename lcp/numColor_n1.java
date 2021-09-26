package leetcode.lcp;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-25 15:01
 **/
public class numColor_n1 {
      public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    Set<Integer> res=new HashSet<>();
    public int numColor(TreeNode root) {
        preOrder(root);
        return res.size();
    }
    void preOrder(TreeNode root){
        if (root!=null){
            res.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
