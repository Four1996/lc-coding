package leetcode;

import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月04日 3:00 下午
 */
@SuppressWarnings({"all"})
public class HasPathSum_n112 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) return false;
        Queue<TreeNode> q=new LinkedList<>();
        Queue<Integer> quesum=new LinkedList<>();
        int sum=0;
        q.add(root);
        quesum.add(root.val);
        while (!q.isEmpty()){
            TreeNode p=q.poll();
            int temp=quesum.poll();
            if (p.left==null&&p.right==null){
                if (temp==targetSum) return true;
            }
            if (p.left!=null){
                q.add(p.left);
                quesum.add(temp+p.left.val);
            }
            if (p.right!=null){
                q.add(p.right);
                quesum.add(temp+p.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode a=new TreeNode(4);
        TreeNode b=new TreeNode(11);
        TreeNode c=new TreeNode(7);
        TreeNode d=new TreeNode(2);
        root.left=a;
        a.left=b;
        b.left=c;
        b.right=d;
        System.out.println(hasPathSum(root,22));

    }
}
