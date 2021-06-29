package leetcode.classic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: first
 * @description: 首个公共祖先
 * @author: panhao
 * @date: 2021-06-29 10:32
 **/
public class LowestCommonAncestor_n2062 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode vis = null;
        boolean tagp = false;
        boolean tagq = false;
        while (root != null || !deque.isEmpty()) {
            if (root != null) {
                deque.addFirst(root);
                if (!tagp && root.val == p.val) {
                    tagp = true;
                    for (TreeNode treeNode : deque) {
                        list1.add(treeNode);
                    }
                }
                if (!tagq && root.val == q.val) {
                    tagq = true;
                    for (TreeNode treeNode : deque) {
                        list2.add(treeNode);
                    }
                }
                if (tagp && tagq) break;
                root = root.left;
            } else {
                root = deque.peekFirst();
                if (root.right != null && vis != root.right) {
                    root = root.right;
                } else {
                    root = deque.pollFirst();
                    vis = root;
                    root = null;
                }
            }
        }
        TreeNode ans = null;
        int pidx = list1.size() - 1;
        int qidx = list2.size() - 1;
        while (pidx >= 0 && qidx >= 0 && list1.get(pidx).val == list2.get(qidx).val) {
            ans = list1.get(pidx);
            pidx--;
            qidx--;
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
        System.out.println(lowestCommonAncestor(a1, new TreeNode(5), new TreeNode(4)).val);
    }
}
