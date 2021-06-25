package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年05月17日 8:52 上午
 */
public class IsCousins_n993_2 {
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
        this.x=x;
        this.y=y;
        Queue<TreeNode> qnode=new LinkedList<>();
        Queue<Integer> qdepth=new LinkedList<>();
        if (root!=null){
            qnode.add(root);
            qdepth.add(1);
        }
        while (!qnode.isEmpty()){
            TreeNode node=qnode.poll();
            int depth=qdepth.poll();
            if (node.left!=null){
                qnode.add(node.left);
                qdepth.add(depth+1);
                check(node.left,depth+1,node);
            }
            if (node.right!=null){
                qnode.add(node.right);
                qdepth.add(depth+1);
                check(node.right,depth+1,node);
            }
            if (xfound&&yfound) break;
        }
        if (xdepth==ydepth&&xparent!=yparent) return true;
        return false;
    }
    void check(TreeNode node,int depth,TreeNode parent){
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
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        System.out.println(new IsCousins_n993_2().isCousins(root, 4, 3));
    }
}
