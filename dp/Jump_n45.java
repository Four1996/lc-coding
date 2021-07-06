package leetcode.dp;

/**
 * @program: first
 * @description: 跳跃游戏2
 * @author: panhao
 * @date: 2021-07-06 21:57
 **/
public class Jump_n45 {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        for (int i = 1, j = 0; i < len; i++) {
            while (j + nums[j] < i) j++;
            f[i] = f[j] + 1;
        }
        return f[len - 1];
    }
}
