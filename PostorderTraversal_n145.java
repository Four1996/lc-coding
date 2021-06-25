package leetcode;

import javax.swing.event.TreeExpansionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年04月05日 10:01 上午
 */
public class PostorderTraversal_n145 {
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
    List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;
    }

    public void postorder(TreeNode T){
        if (T!=null){
            postorder(T.left);
            postorder(T.right);
            list.add(T.val);
        }
    }
}
