package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年05月03日 10:53 上午
 */
public class IsSymmetric_n101_2 {
    public class TreeNode {
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



    public boolean isSymmetric(TreeNode root) {

        return check(root,root);
    }
    boolean check(TreeNode p,TreeNode q){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()){
            p=queue.poll();
            q=queue.poll();
            if (p==null&&q==null){
                continue;
            }
            if ((p==null||q==null)||(p.val!=q.val)){
                return false;
            }
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }
}
