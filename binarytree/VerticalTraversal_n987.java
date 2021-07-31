package leetcode.binarytree;

import java.util.*;

/**
 * @program: first
 * @description: 二叉树的垂序遍历
 * @author: panhao
 * @date: 2021-07-31 09:30
 **/
public class VerticalTraversal_n987 {
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

    public static class point {
        int val;
        int col;
        int level;

        public point(int val, int col, int level) {
            this.val = val;
            this.col = col;
            this.level = level;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> deque_col = new ArrayDeque<>();
        Deque<Integer> deque_level = new ArrayDeque<>();
        List<point> res = new ArrayList<>();
        if (root != null) {
            deque.addFirst(root);
            deque_col.addFirst(0);
            deque_level.addFirst(0);
        }
        while (!deque.isEmpty() && !deque_col.isEmpty()&&!deque_level.isEmpty()) {
            TreeNode node = deque.pollLast();
            Integer col = deque_col.pollLast();
            Integer level = deque_level.pollLast();
            res.add(new point(node.val, col, level));
            if (node.left != null) {
                deque.addFirst(node.left);
                deque_col.addFirst(col - 1);
                deque_level.addFirst(level + 1);
            }
            if (node.right != null) {
                deque.addFirst(node.right);
                deque_col.addFirst(col + 1);
                deque_level.addFirst(level + 1);
            }
        }
        res.sort(new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                if (o1.col != o2.col) {
                    return o1.col - o2.col;
                } else if (o1.level != o2.level) {
                    return o1.level - o2.level;
                } else {
                    return o1.val - o2.val;
                }
            }
        });
        List<Integer> temp = new ArrayList<>();
        int pre = 0;
        for (point p : res) {
            if (temp.isEmpty()) temp.add(p.val);
            else {
                if (p.col == pre) temp.add(p.val);
                else {
                    ans.add(new ArrayList<>(temp));
                    temp.clear();
                    temp.add(p.val);
                }
            }
            pre = p.col;
        }
        if (!temp.isEmpty()) ans.add(new ArrayList<>(temp));
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a1 = new TreeNode(9);
        TreeNode a2 = new TreeNode(20);
        TreeNode a3 = new TreeNode(15);
        TreeNode a4 = new TreeNode(7);
        root.left = a1;
        root.right = a2;
        a2.left = a3;
        a2.right = a4;
        System.out.println(verticalTraversal(root));
    }
}
