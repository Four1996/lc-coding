package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年04月11日 9:44 下午
 */
public class LowestCommonAncestor_n236 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode() {

        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();
        boolean judge = false;
        prefind(root, p.val, q1, judge);
        judge = false;
        prefind(root, q.val, q2, judge);
        TreeNode father = root;
        while (q1.poll().val == q2.poll().val && !q1.isEmpty() && !q2.isEmpty()) {
            father = q1.poll();
        }
        return father;
    }

    void prefind(TreeNode t, int target, Queue<TreeNode> q, boolean judge) {
        if (judge == false && t != null) {
            q.add(t);
            if (t.val == target) {
                judge = true;
                return;
            }
            prefind(t.left, target, q, judge);
            prefind(t.right, target, q, judge);

        }
    }
    static TreeNode createBinaryTree(Queue<Integer> nums){
        Queue<TreeNode> q=new ArrayDeque<>();
        TreeNode root=new TreeNode();
        TreeNode tail=root;
        if (!nums.isEmpty()){
            TreeNode node=new TreeNode();
            node.val=nums.poll();
            tail=node;
            q.add(node);
            while(!q.isEmpty()){

            }
        }
        return root;
    }

    public static void main(String[] args) {
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(3);
        queue.add(5);
        queue.add(1);
        queue.add(6);
        queue.add(2);
        queue.add(0);
        queue.add(8);
        queue.add(null);
        queue.add(null);
        queue.add(7);
        queue.add(4);
        createBinaryTree(queue);
    }
}
