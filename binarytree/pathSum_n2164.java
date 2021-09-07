package leetcode.binarytree;

import java.util.HashMap;

/**
 * @program: first
 * @description: 向下的路径结点之和
 * @author: panhao
 * @date: 2021-09-06 20:01
 **/
public class pathSum_n2164 {
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

    HashMap<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0, 1);
        return dfs(root, targetSum, 0);
    }

    int dfs(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        sum += node.val;
        res += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        res += dfs(node.left, targetSum, sum);
        res += dfs(node.right, targetSum, sum);
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}
