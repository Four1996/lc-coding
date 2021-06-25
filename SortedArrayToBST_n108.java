package leetcode;

/**
 * @author panhao
 * @date 2021年05月04日 10:37 上午
 */
public class SortedArrayToBST_n108 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return midBuild(nums,0,nums.length-1);
    }
    public TreeNode midBuild(int[] nums,int left,int right){
        if (left>right) return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=midBuild(nums,left,mid-1);
        root.right=midBuild(nums,mid+1,right);
        return root;
    }
}
