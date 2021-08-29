package leetcode.array;

/**
 * @program: first
 * @description: 所有奇数长度子数组的和
 * @author: panhao
 * @date: 2021-08-29 09:15
 **/
public class SumOddLengthSubarrays_n1588 {
    public static int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        int len = arr.length;
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = arr[i - 1] + preSum[i - 1];
        }
        int window = 1;
        while (window <= len) {
            int left = 0, right = left + window - 1;
            while (right < len) {
                ans += preSum[right + 1] - preSum[left];
                left ++;
                right = left + window - 1;
            }
            window += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(sumOddLengthSubarrays(nums));
    }
}
