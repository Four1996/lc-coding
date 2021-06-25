package leetcode;

/**
 * @author panhao
 * @date 2021年04月14日 8:03 下午
 */
public class FindMedianSortedArrays_n4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int l1 = nums1.length, l2 = nums2.length;
        int lleft = (l1 + l2 + 1) / 2;//向上取整，使得分割线左边的元素比右边元素个数多1.
        int left=0,right=l1;
        while (left<right){
            int i=left+(right-left+1)/2;
            int j=lleft-i;
            if (nums1[i-1]>nums2[j]) right=i-1;
            else left=i;
        }
        int i=left;
        int j=lleft-i;
        int num1LeftMax=i==0?Integer.MIN_VALUE:nums1[i-1];
        int num2LeftMax=j==0?Integer.MIN_VALUE:nums2[j-1];
        int num1RightMax=i==l1?Integer.MAX_VALUE:nums1[i];
        int num2RightMax=j==l2?Integer.MAX_VALUE:nums2[j];
        if ((l1+l2)%2==1){
            return Math.max(num1LeftMax,num2LeftMax);
        }else{
            return (double)(Math.max(num1LeftMax,num2LeftMax)+Math.min(num1RightMax,num2RightMax))/2;
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays_n4 findMedianSortedArrays_n4=new FindMedianSortedArrays_n4();
        int[] nums1={2,3};
        int[] nums2={1};
        System.out.println(findMedianSortedArrays_n4.findMedianSortedArrays(nums1,nums2));
    }
}
