package leetcode.array;

import java.util.Arrays;

/**
 * @program: first
 * @description: 有效三角新的个数
 * @author: panhao
 * @date: 2021-08-04 09:56
 **/
public class TriangleNumber_n611_2 {
    public static int triangleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < len-2; i++) {
            for (int j = i + 1; j < len-1; j++) {
                int left = j + 1, right = len - 1;
                int two = nums[i] + nums[j];
                int k = j;
                // 为什么是等号呢？因为left每次移动，移动的都是mid的下一位，
                // 这样如若left与right相等的时候，就会导致漏判。
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (two > nums[mid]) {
                        k = mid;
                        left = mid + 1;
                    } else right = mid - 1;
                }
                ans += (k - j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2};
        System.out.println(triangleNumber(nums));
    }
}
