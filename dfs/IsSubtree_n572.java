package leetcode.dfs;

/**
 * @program: first
 * @description: 另一个树的子树
 * @author: panhao
 * @date: 2021-07-09 15:17
 **/
public class IsSubtree_n572 {
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot);
    }
    public boolean dfs(TreeNode s,TreeNode t){
        if (s==null) return false;
        return judge(s,t)||dfs(s.left,t)||dfs(s.right,t);
    }
    boolean judge(TreeNode s,TreeNode t){
        if (s==null&&t==null) return true;
        if (s==null||t==null||s.val!=t.val) return false;
        return judge(s.left,t.left)&&judge(s.right,t.right);
    }
}
