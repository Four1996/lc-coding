package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: first
 * @description: 所有大于等于节点的值之和
 * @author: panhao
 * @date: 2021-09-06 21:45
 **/
public class convertBST_n2168 {
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

    TreeNode[] nodes;
    Deque<TreeNode> deque;
    List<Integer> preSum;
    int sum;

    public TreeNode convertBST(TreeNode root) {
        deque = new ArrayDeque<>();
        sum = 0;
        preSum=new ArrayList<>();
        preSum.add(0);
        inorderSearch(root);
        int len = deque.size();
        nodes = new TreeNode[len];
        int idx = 0;
        while (!deque.isEmpty()) {
            deque.pollLast().val = sum - preSum.get(idx++);
        }
        return root;
    }

    void inorderSearch(TreeNode node) {
        if (node != null) {
            inorderSearch(node.left);
            deque.addFirst(node);
            sum += node.val;
            preSum.add(sum);
            inorderSearch(node.right);
        }
    }
}
