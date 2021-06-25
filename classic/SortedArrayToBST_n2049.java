package leetcode.classic;


/**
 * @program: first
 * @description: 最小高度树
 * @author: panhao
 * @date: 2021-06-25 15:25
 **/
public class SortedArrayToBST_n2049 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;
        if (len<1) return null;
        int mid=(len/2);
        TreeNode root=new TreeNode(nums[mid]);
        root.left=create(nums,0,mid);
        root.right=create(nums,mid+1,len);
        return root;
    }
    public static TreeNode create(int[] nums,int left,int right){
        if (left>=right) return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=create(nums,0,mid);
        root.right=create(nums,mid+1,right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }
}
