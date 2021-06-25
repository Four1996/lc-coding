package leetcode;

/**
 * @author panhao
 * @date 2021年05月03日 10:37 上午
 */
public class IsSameTree_n100 {
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
    boolean tag=true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode tail1=p;
        TreeNode tail2=q;
        preOrder(p,q);
        return tag;
    }
    void preOrder(TreeNode p,TreeNode q){
        if ((p==null&&q!=null)||p!=null&&q==null){
            tag=false;
            return;
        }else{
            if (p!=null&&q!=null){
                if (p.val!=q.val){
                    tag=false;
                    return;
                }
                preOrder(p.left,q.left);
                preOrder(p.right,q.right);
            }
        }
    }
}
