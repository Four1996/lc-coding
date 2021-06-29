package leetcode.classic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 后继者
 * @author: panhao
 * @date: 2021-06-29 09:41
 **/
public class InorderSuccessor_n2060 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean find = false;
        while (root != null || !deque.isEmpty()) {
            if (root != null) {
                deque.addFirst(root);
                root = root.left;
            } else {
                root = deque.pollFirst();
                if (find) return root;
                if (root.val == p.val) find = true;
                root = root.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(3);
        a1.left = a2;
        a1.right = a3;
        System.out.println(inorderSuccessor(a1, new TreeNode(1)));
    }

}
