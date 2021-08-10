package leetcode.bitoperation;

/**
 * @program: first
 * @description: 只出现一次的数字
 * @author: panhao
 * @date: 2021-08-10 09:49
 **/
public class SingleNumber_n2085 {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += ((num >>= i) & 1);
            }
            sum %= 3;
            ans += (sum << i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-2,1,1,4,1,4,4,-4,-2};
        System.out.println(singleNumber(nums));
    }
}
