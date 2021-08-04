package leetcode.array;

import java.util.Arrays;

/**
 * @program: first
 * @description: 有效三角新的个数
 * @author: panhao
 * @date: 2021-08-04 09:56
 **/
public class TriangleNumber_n611_3 {
    public static int triangleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j=i-1,k=0;k<j;j--){
                while (k<j&&nums[k]+nums[j]<=nums[i]) {
                    k++;
                }
                ans+=j-k;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 4};
        System.out.println(triangleNumber(nums));
    }
}
