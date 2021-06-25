package leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author panhao
 * @date 2021年04月13日 8:50 上午
 */
public class MinDiffInBST_n783 {
    static class TreeNode {
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

    static List<Integer> list = new ArrayList<>();

    public static int minDiffInBST(TreeNode root) {

        TreeNode tail = root;
        if (tail != null) prefind(tail, list);
        Object[] nums=list.toArray();
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i=1;i<nums.length;i++){
            min=Math.min(min,Math.abs((int)nums[i]-(int)nums[i-1]));
        }
        return min;
    }

    static void prefind(TreeNode root, List<Integer> list) {
        TreeNode tail = root;
        if (tail != null) {
            list.add(tail.val);
            prefind(tail.left, list);
            prefind(tail.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(7);
        TreeNode node1=new TreeNode(5,node2,node3);
        System.out.println(minDiffInBST(node1));
    }
}
