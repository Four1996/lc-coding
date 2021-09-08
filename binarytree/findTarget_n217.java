package leetcode.binarytree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: first
 * @description: 二叉搜索树中两个节点之和
 * @author: panhao
 * @date: 2021-09-07 14:38
 **/
public class findTarget_n217 {
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

    HashSet<Integer> map = new HashSet<>();
    boolean res = false;

    public boolean findTarget(TreeNode root, int k) {
        preSearch(root, k);
        return res;
    }

    void preSearch(TreeNode node, int k) {
        if (node != null) {
            if (map.contains(k - node.val)) {
                res = true;
                return;
            } else {
                map.add(node.val);
            }
            if (!res) {
                preSearch(node.left, k);
                preSearch(node.right, k);
            }
        }
    }
}
