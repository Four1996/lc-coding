package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BSTIterator_n173 {
    Deque<TreeNode> q=new ArrayDeque<>();
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

    public BSTIterator_n173(TreeNode root) {//初始化中序遍历
        dfsLeft(root);
    }
    public int next(){//即获得当前栈中结点，并将其赋值右节点，然后继续进行深度遍历。
        TreeNode root=q.pollLast();
        int ans=root.val;
        root=root.right;
        dfsLeft(root);
        return ans;
    }
    public boolean hasNext(){//判断当前栈是否为空，如果为空说明当前二叉树已经没有元素可以弹出，即全部遍历完毕，此时应该返回false，否则返回true。
        if (q.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    void dfsLeft(TreeNode root){//中序遍历
        while (root!=null){
            q.addLast(root);
            root=root.left;
        }
    }
}
