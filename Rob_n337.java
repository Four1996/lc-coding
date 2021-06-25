package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月27日 3:56 下午
 */
public class Rob_n337 {
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

    public static int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return robInternal(root, map);
    }

    public static int robInternal(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int money = root.val;
        if (root.left != null) {
            money += (robInternal(root.left.left,map) + robInternal(root.left.right,map));
        }
        if (root.right != null) {
            money += (robInternal(root.right.left,map) + robInternal(root.right.right,map));
        }
        int res = Math.max(money, robInternal(root.left,map) + robInternal(root.right,map));
        map.put(root, res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        System.out.println(rob(node));
    }
}
