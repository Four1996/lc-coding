package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-04 22:30
 **/
public class findMiddleIndex_n5846 {
    public int findMiddleIndex(int[] nums) {
        int len = nums.length;
        int[] preSum = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                preSum[i] = nums[i];
            } else {
                preSum[i] = nums[i] + preSum[i - 1];
            }
        }
        for (int i = 0; i < len; i++) {
            int right = preSum[len - 1] - preSum[i];
            int left;
            if (i == 0) {
                left = 0;
            } else {
                left = preSum[i - 1];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
