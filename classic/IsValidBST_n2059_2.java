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
public class IsValidBST_n2059_2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public static boolean helper(TreeNode node,Integer lower,Integer upper){
        if (node==null) return true;
        int val=node.val;
        if (lower!=null&&val<=lower) return false;
        if (upper!=null&&val>=upper) return false;
        if (!helper(node.right,val,upper)) return false;
        if (!helper(node.left,lower,val)) return false;
        return true;
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
