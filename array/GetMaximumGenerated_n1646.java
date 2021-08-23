package leetcode.array;

/**
 * @program: first
 * @description: 获取生成数组中的最大值
 * @author: panhao
 * @date: 2021-08-23 09:20
 **/
public class GetMaximumGenerated_n1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (i%2==0){
                nums[i] = nums[i/2];
            }else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            ans = Math.max(nums[i], ans);
        }
        return ans;
    }
}
