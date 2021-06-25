package leetcode.swordoffer;

import com.sun.source.tree.IfTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年05月19日 6:59 下午
 */
public class IsSymmetric_n1931 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkTree(root,root);
    }
    boolean checkTree(TreeNode leftTree,TreeNode rightTree){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(leftTree);
        q.add(rightTree);
        while (!q.isEmpty()){
            leftTree=q.poll();
            rightTree=q.poll();
            if (leftTree==null&&rightTree==null) continue;
            if ((leftTree==null||rightTree==null)||leftTree.val!= rightTree.val) return false;
            q.add(leftTree.left);
            q.add(rightTree.right);
            q.add(leftTree.right);
            q.add(rightTree.left);
        }
        return true;
    }
}
