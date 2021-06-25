package leetcode.swordoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月07日 2:23 下午
 */
public class LowestCommonAncestor_n2001 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listp = new ArrayList<>();
        List<TreeNode> listq = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode n = root;
        TreeNode r = null;
        while (n != null || !deque.isEmpty()) {
            if (n != null) {
                deque.add(n);
                if (n.val == p.val) {
                    for (TreeNode treeNode : deque) {
                        listp.add(treeNode);
                    }
                }
                if (n.val == q.val) {
                    for (TreeNode treeNode : deque) {
                        listq.add(treeNode);
                    }
                }
                if (!listp.isEmpty() && !listq.isEmpty()) break;
                n = n.left;
            } else {
                n = deque.peekLast();
                if (n.right != null && n.right != r) {
                    n = n.right;
                } else {
                    n = deque.pollLast();
//                    System.out.println(n.val);
                    r = n;
                    n = null;
                }
            }
        }
        TreeNode ans = null;
        while (!listp.isEmpty() && !listq.isEmpty() && listp.get(0).val == listq.get(0).val) {
            ans = listp.get(0);
            listp.remove(0);
            listq.remove(0);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(5);
        TreeNode a3 = new TreeNode(1);
        TreeNode a4 = new TreeNode(6);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(0);
        TreeNode a7 = new TreeNode(8);
        TreeNode a8 = new TreeNode(7);
        TreeNode a9 = new TreeNode(4);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        a5.left = a8;
        a5.right = a9;
        System.out.println(lowestCommonAncestor(a1, a2, a9).val);
    }
}
