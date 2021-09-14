package leetcode;

import java.util.HashMap;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * @author panhao
 * @date 2021年05月08日 10:51 上午
 */
public class BuildTree_n1895 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static HashMap<Integer,Integer> map=new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode ans = build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        return ans;
    }
     static TreeNode build(int[] preOrder,int[] inOrder,int preleft,int preright,int inleft,int inright){
        if (preleft>preright) {
            return null;
        }
//      前序遍历的第一个结点就是根节点。
        int rootnode=preleft;
//        在中序遍历中定位根节点位置
        int rootIndex_inorder=map.get(preOrder[rootnode]);
        TreeNode root=new TreeNode(preOrder[rootnode]);
//        获得根节点在中序遍历中的左子树结点个数
        int size_left_subtree=rootIndex_inorder-inleft;
//        递归构建左子树，并连接到根节点
        root.left=build(preOrder,inOrder,preleft+1,preleft+size_left_subtree,inleft,rootIndex_inorder-1);
//        递归构建右子树，并连接到根节点
        root.right=build(preOrder,inOrder,preleft+size_left_subtree+1,preright,rootIndex_inorder+1,inright);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder={3,9,6,20,15,7};
        int [] inorder={6,9,3,15,20,7};
        System.out.println(buildTree(preorder,inorder));
    }
}
