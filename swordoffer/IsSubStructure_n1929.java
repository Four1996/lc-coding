package leetcode.swordoffer;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年05月19日 3:44 下午
 */
public class IsSubStructure_n1929 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        Queue<TreeNode> qa = new LinkedList<>();
        if (A!=null) qa.add(A);
        while (!qa.isEmpty()){
            TreeNode node=qa.poll();
            if (node.val==B.val){
                if (dfs(node,B)) return true;
            }
            if (node.left!=null) qa.add(node.left);
            if (node.right!=null) qa.add(node.right);
        }
        return false;
    }
    static boolean dfs(TreeNode A,TreeNode B){
        Queue<TreeNode> qb=new LinkedList<>();
        Queue<TreeNode> qa=new LinkedList<>();
        qb.add(B);
        qa.add(A);
        while (!qb.isEmpty()&&!qa.isEmpty()) {
            TreeNode nodea = qa.poll();
            TreeNode nodeb = qb.poll();
            if (nodea.val != nodeb.val) return false;
            else {
                if (nodea.left != null) qa.add(nodea.left);
                if (nodea.right != null) qa.add(nodea.right);
                if (nodeb.left != null) qb.add(nodeb.left);
                if (nodeb.right != null) qb.add(nodeb.right);
            }
        }
        if (!qb.isEmpty()) return false;
        return true;
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
