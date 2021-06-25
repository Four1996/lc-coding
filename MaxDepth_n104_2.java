package leetcode;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author panhao
 * @date 2021年05月04日 10:17 上午
 */
public class MaxDepth_n104_2 {
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

    public int maxDepth(TreeNode root) {

        if (root==null) return 0;
        int ans=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size=q.size();
            while (size>0){
                TreeNode p=q.poll();
                if (p.left!=null) q.add(p.left);
                if (p.right!=null) q.add(p.right);
               --size;
            }
            ++ans;
        }
        return ans;
    }
}
