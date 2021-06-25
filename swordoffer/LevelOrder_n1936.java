package leetcode.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年05月19日 10:30 下午
 */
public class LevelOrder_n1936 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> ansList=new ArrayList<>();
        if (root!=null) {
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for (int i=queue.size();i>0;--i ){
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            ansList.add(list);

        }
        return ansList;
    }
}
