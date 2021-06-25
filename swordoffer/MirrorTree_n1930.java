package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月19日 4:51 下午
 */
public class MirrorTree_n1930 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root==null) return null;
        TreeNode ans =new TreeNode(root.val);
        preOrder(root,ans);
        return ans;
    }
    static void preOrder(TreeNode root,TreeNode ans){
        if (root!=null){
            if (root.left!=null){
                TreeNode node=new TreeNode(root.left.val);
                ans.right= node;
                preOrder(root.left,ans.right);
            }
            if (root.right!=null){
                TreeNode node=new TreeNode(root.right.val);
                ans.left=node;
                preOrder(root.right,ans.left);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode a1=new TreeNode(4);
        TreeNode a2=new TreeNode(2);
        TreeNode a3=new TreeNode(7);
        TreeNode a4=new TreeNode(1);
        TreeNode a5=new TreeNode(3);
        TreeNode a6=new TreeNode(6);
        TreeNode a7=new TreeNode(9);
        a1.left=a2;
        a1.right=a3;
        a2.left=a4;
        a2.right=a5;
        a3.left=a6;
        a3.right=a7;
        mirrorTree(a1);
    }
}
