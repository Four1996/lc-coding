package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @program: first
 * @description: 序列化与反序列化二叉树
 * @author: panhao
 * @date: 2021-09-06 15:04
 **/
public class Codec_n2162 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int INF = Integer.MIN_VALUE;

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollLast();
                if (treeNode.val == INF) {
                    sb.append("null,");
                } else {
                    int num = treeNode.val;
                    sb.append(num + ",");
                    if (treeNode.left != null) {
                        deque.addFirst(treeNode.left);
                    } else {
                        deque.addFirst(new TreeNode(INF));
                    }
                    if (treeNode.right != null) {
                        deque.addFirst(treeNode.right);
                    } else {
                        deque.addFirst(new TreeNode(INF));
                    }
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        int len = data.length();
        data = data.substring(1, len - 1);
        if (data.length() == 0) {
            return null;
        }
        String[] split = data.split(",");
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        deque.addFirst(root);
        int idx = 1;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (!"null".equals(split[idx])) {
                node.left = new TreeNode(Integer.parseInt(split[idx]));
                deque.addFirst(node.left);
            }
            idx++;
            if (!"null".equals(split[idx])) {
                node.right = new TreeNode(Integer.parseInt(split[idx]));
                deque.addFirst(node.right);
            }
            idx++;
        }
        return root;
    }

    public static void main(String[] args) {
        String s = "[1,2,3,null,null,4,5,6,7]";
        System.out.println(deserialize(s));
    }
}
