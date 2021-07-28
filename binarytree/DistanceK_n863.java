package leetcode.binarytree;

import java.util.*;

/**
 * @program: first
 * @description: 二叉树中所有距离为K的结点
 * @author: panhao
 * @date: 2021-07-28 10:07
 **/
public class DistanceK_n863 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (node.left != null) {
                map.put(node.left, node);
                deque.addFirst(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                deque.addFirst(node.right);
            }
        }
        HashSet<TreeNode> vis = new HashSet<>();
        deque.addFirst(target);
        vis.add(target);
        int step = 0;
        List<Integer> ans = new ArrayList<>();
        if (step==k) ans.add(deque.pollLast().val);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollLast();
                if (map.containsKey(node) && !vis.contains(map.get(node))) {
                    deque.addFirst(map.get(node));
                    vis.add(map.get(node));
                }

                if (node.left != null && !vis.contains(node.left)) {
                    deque.addFirst(node.left);
                    vis.add(node.left);
                }

                if (node.right != null && !vis.contains(node.right)) {
                    deque.addFirst(node.right);
                    vis.add(node.right);
                }
            }
            step++;
            if (step == k) {
                while (!deque.isEmpty()) {
                    ans.add(deque.pollLast().val);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode a1=new TreeNode(5);
        TreeNode a2=new TreeNode(1);
        TreeNode a3=new TreeNode(6);
        TreeNode a4=new TreeNode(2);
        TreeNode a5=new TreeNode(0);
        TreeNode a6=new TreeNode(8);
        TreeNode a7=new TreeNode(7);
        TreeNode a8=new TreeNode(4);
        root.left=a1;
        root.right=a2;
        a1.left=a3;
        a1.right=a4;
        a2.left=a5;
        a2.right=a6;
        a4.left=a7;
        a4.right=a8;
        System.out.println(distanceK(root,a1,2));
    }
}
