package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月09日 11:23 上午
 */
public class MaxDistance_n5751 {
    public static int maxDistance(int[] nums1, int[] nums2) {
        int l1=nums1.length,l2=nums2.length;
        int left=0,right=l2-1;
        while (left<right){
            int mid=(left+right+1)/2;
            if (isSuccess(nums1,nums2,mid)){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    static boolean isSuccess(int[] nums1,int[] nums2,int dis){
        int l1=nums1.length,l2=nums2.length;
        for (int i=0,j=i+dis;i<l1&&j<l2;){
            if (nums1[i]<=nums2[j]) return true;
            else{
                ++i;
                ++j;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums1={5,4};
        int[] nums2={3,2};
        System.out.println(maxDistance(nums1,nums2));
    }
}
