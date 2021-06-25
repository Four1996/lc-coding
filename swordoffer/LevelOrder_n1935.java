package leetcode.swordoffer;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月19日 10:19 下午
 */
public class LevelOrder_n1935 {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static int[] levelOrder(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }
        Object[] objects = list.toArray();
        int[] ans=new int[objects.length];
        int i=0;
        for (Object o:objects){
            ans[i]= (int) o;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(9);
        TreeNode node3=new TreeNode(20);
        TreeNode node4=new TreeNode(15);
        TreeNode node5=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        System.out.println(levelOrder(node1));
    }
}
