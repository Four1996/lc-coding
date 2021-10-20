package leetcode.array;

/**
 * @program: first
 * @description: 最小操作次数使数组元素相等
 * @author: panhao
 * @date: 2021-10-20 21:32
 **/
public class minMoves_n453 {
    public int minMoves(int[] nums) {
        int n = nums.length;
        long min = nums[0], sum = 0;
        for (int i : nums) {
            min = Math.min(min, i);
            sum += i;
        }
        return (int)(sum - min * n);
    }
}
