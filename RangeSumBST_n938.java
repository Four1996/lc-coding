package leetcode;

/**
 * @author panhao
 * @date 2021年04月27日 9:12 上午
 */
public class RangeSumBST_n938 {
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
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
            innerOrder(root,low,high);
            return sum;
    }
    void innerOrder(TreeNode root,int low,int high){
        if (root!=null){
            innerOrder(root.left,low,high);
            if (root.val>=low&&root.val<=high){
                sum+=root.val;
            }
            innerOrder(root.right,low,high);
        }
    }
}
