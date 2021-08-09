package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: dfs方法
 * @description: 二叉树的右视图
 * @author: panhao
 * @date: 2021-08-09 16:28
 **/
public class RightSideView_n199_2 {
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

    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        rightPreOrder(root,0);
        return ans;
    }
    void rightPreOrder(TreeNode node,int depth) {
        if (node != null) {
            if (depth == ans.size()) {
                ans.add(node.val);
            }
            rightPreOrder(node.right, depth + 1);
            rightPreOrder(node.left, depth + 1);
        }
    }

}
