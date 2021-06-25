package leetcode;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月17日 8:52 上午
 */
public class IsCousins_n993 {
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


    int xdepth = 0;
    int ydepth = 0;
    TreeNode xparent;
    TreeNode yparent;
    static int x;
    static int y;
    boolean xfound=false;
    boolean yfound=false;
    public boolean isCousins(TreeNode root, int x, int y) {
        int depth = 0;
        this.x=x;
        this.y=y;
        dfs(root.left,depth+1,root);
        dfs(root.right,depth+1,root);
        if (xdepth==ydepth&&xparent!=yparent) return true;
        return false;
    }

     void dfs(TreeNode node,int depth,TreeNode parent) {
        if (node==null) return;
        if (node.val==x){
            xdepth=depth;
            xparent=parent;
            xfound=true;
        }
        if (node.val==y){
            ydepth=depth;
            yparent=parent;
            yfound=true;
        }
        if (xfound&&yfound) return;
        dfs(node.left,depth+1,node);
        dfs(node.right,depth+1,node);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        System.out.println(new IsCousins_n993().isCousins(root, 4, 3));
    }
}
