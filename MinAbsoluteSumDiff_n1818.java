package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description: 绝对差值和
 * @author: panhao
 * @date: 2021-07-14 09:46
 **/
public class MinAbsoluteSumDiff_n1818 {
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) (1e9 + 7);
        int len = nums1.length;
        int sum = 0;
        int maxvalue = 0;
        int max_abs = 0;
        int[] dumy = Arrays.copyOfRange(nums1, 0, len);
        Arrays.sort(dumy);
        for (int i = 0; i < len; i++) {
            // 当前元素绝对值
            int abs = Math.abs(nums1[i] - nums2[i]);
            if (abs == 0) continue;
            // 二分找到的最接近nums2[i]的元素
            int bs = bs(dumy, nums2[i]);
            // 绝对差值
            int s_abs = Math.abs(dumy[bs] - nums2[i]);
            // 如果绝对差值小于原来的绝对差值，说明能够减少绝对差值
            if (s_abs < abs && s_abs > max_abs) {
                // 记录能够替换的最大差值
                max_abs = s_abs;
                maxvalue = abs;
            }
            sum += abs % mod;
        }
        return sum - maxvalue + max_abs;
    }
    static int bs(int[] dumy, int tar){
        int left=0,right= dumy.length-1;
        while (left<right){
            int mid = left + (right - left) / 2;
            if (dumy[mid] >= tar) right = mid;
            else left = mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums1={1,10,4,4,2,7};
        int[] nums2={9,3,5,1,7,4};
        System.out.println(minAbsoluteSumDiff(nums1,nums2));

    }
}
