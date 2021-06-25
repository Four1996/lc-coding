package leetcode.swordoffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author panhao
 * @date 2021年06月06日 9:55 下午
 */
public class LowestCommonAncestor_n2000 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if (root.val<p.val&&root.val<q.val){
                root=root.right;
            }else if (root.val>p.val&&root.val>q.val){
                root=root.left;
            }else{
                break;
            }
        }
        return root;
    }
}
