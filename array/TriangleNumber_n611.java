package leetcode.array;

import java.util.Arrays;

/**
 * @program: first
 * @description: 有效三角新的个数
 * @author: panhao
 * @date: 2021-08-04 09:56
 **/
public class TriangleNumber_n611 {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j]) {
                        ans++;
                    } else if (nums[i] + nums[j] < nums[k]) {
                        break;
                    }
                }
            }

        }
        return ans;
    }
}
