package leetcode.classic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: first
 * @description: 合法二叉搜索树
 * @author: panhao
 * @date: 2021-06-29 09:02
 **/
public class IsValidBST_n2059 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<Integer> list = new ArrayList<>();

    public static boolean isValidBST(TreeNode root) {
        midOrder(root);
        Stack s=new Stack();
        boolean tag = true;
        if (list.size() < 2) return true;
        else {

            for (Integer integer : list) {
               if (s.isEmpty()) s.push(integer);
               else{
                   Integer peek = (Integer) s.peek();
                   if (integer>peek){
                       s.push(integer);
                   }else{
                       tag=false;
                       break;
                   }
               }
            }
        }
        return tag;
    }

    static void midOrder(TreeNode root) {
        if (root == null) return;
        else {
            midOrder(root.left);
            list.add(root.val);
            midOrder(root.right);
        }
    }

    public static void main(String[] args) {

        TreeNode a1=new TreeNode(5);
        TreeNode a2=new TreeNode(1);
        TreeNode a3=new TreeNode(4);
        TreeNode a4=new TreeNode(3);
        TreeNode a5=new TreeNode(6);
        a1.left=a2;
        a1.right=a3;
        a3.left=a4;
        a3.right=a5;
        System.out.println(isValidBST(a1));

    }

}
