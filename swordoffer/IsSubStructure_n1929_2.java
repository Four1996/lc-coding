package leetcode.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年05月19日 3:44 下午
 */
public class IsSubStructure_n1929_2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null||A==null) return false;
        if (recur(A,B)) return true;
        return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    static boolean recur(TreeNode A,TreeNode B){
        if (B==null) return true;
        if (A==null||A.val!=B.val) return false;
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }

    public static void main(String[] args) {
        TreeNode a1=new TreeNode(1);
        TreeNode a2=new TreeNode(0);
        TreeNode a3=new TreeNode(1);
        TreeNode a4=new TreeNode(-4);
        TreeNode a5=new TreeNode(-3);
        TreeNode b1=new TreeNode(1);
        TreeNode b2=new TreeNode(-4);
        a1.left=a2;
        a1.right=a3;
        a2.left=a4;
        a2.right=a5;
        b1.left=b2;
        System.out.println(isSubStructure(a1,b1));
    }
}
