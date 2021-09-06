package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-05 22:31
 **/
public class rightSideView_n2160 {
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
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        ans=new ArrayList<>();
        dfs(root,0);
        return ans;
    }
    public void dfs(TreeNode root,int depth){
        if (root!=null){
            if (ans.size()<=depth){
                ans.add(root.val);
            }
            dfs(root.right,depth+1);
            dfs(root.left,depth+1);
        }
    }
}