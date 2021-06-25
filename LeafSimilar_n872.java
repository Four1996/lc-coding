package leetcode;

import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月10日 7:56 上午
 */
public class LeafSimilar_n872 {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        preOrder(root1,s1);
        preOrder(root2,s2);
        while (!s1.isEmpty()&&!s2.isEmpty()){
            int u1=s1.pop();
            int u2=s2.pop();
            if (u1!=u2) return false;
        }
        if (!s1.isEmpty()||!s2.isEmpty()) return false;
        return true;
    }
    void preOrder(TreeNode root,Stack<Integer> s){
        if (root!=null){
            if (root.left==null&&root.right==null) s.push(root.val);
            preOrder(root.left,s);
            preOrder(root.right,s);
        }
    }
}
