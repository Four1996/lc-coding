package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 二叉搜索树迭代器
 * @author: panhao
 * @date: 2021-09-07 10:32
 **/
public class BSTIterator_n2169 {
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

    List<Integer> res;
    int idx = 0;

    public BSTIterator_n2169(TreeNode root) {
        res = new ArrayList<>();
        inorderSearch(root);
    }

    void inorderSearch(TreeNode node) {
        if (node != null) {
            inorderSearch(node.left);
            res.add(node.val);
            inorderSearch(node.right);
        }
    }

    public int next() {
        return res.get(idx++);
    }

    public boolean hasNext() {
        if (idx >= res.size()) {
            return false;
        } else {
            return true;
        }
    }
}
