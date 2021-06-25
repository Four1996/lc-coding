package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月05日 9:23 上午
 */
public class Merge_n88 {
    public static void merge(int[] nums1,int m,int[] nums2,int n){
        for (int i=m,j=0;i<m+n&&j<n;i++,j++){
            nums1[i]=nums2[j];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int [] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
    }
}
