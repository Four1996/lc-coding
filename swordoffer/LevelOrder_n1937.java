package leetcode.swordoffer;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月19日 10:50 下午
 */
public class LevelOrder_n1937 {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue =new ArrayDeque<>();
        List<List<Integer>> ansList=new ArrayList<>();
        if (root!=null) queue.add(root);
        int level=1;
        while (!queue.isEmpty()){
            LinkedList<Integer> list=new LinkedList<>();
            for (int i = queue.size(); i>0; i--){
                TreeNode node=queue.poll();
                if (level%2==0) list.addLast(node.val);
                else list.addFirst(node.val);
                if (node.right!=null) queue.add(node.right);
                if (node.left!=null) queue.add(node.left);
            }
            ansList.add(list);
            level++;
        }
        return  ansList;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.right=node5;
        System.out.println(levelOrder(node1));
    }
}
