package leetcode.prefix_sum;

/**
 * @program: first
 * @description: 找到需要补充粉笔的学生编号
 * @author: panhao
 * @date: 2021-09-10 09:12
 **/
public class chalkReplacer_n1894 {
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        long[] preSum = new long[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                preSum[i] = chalk[i];
            } else {
                preSum[i] = chalk[i] + preSum[i - 1];
            }
            sum += chalk[i];
        }
        k %= sum;
        for (int i = 0; i < len; i++) {
            if (k < preSum[i]) {
                return i;
            }
        }
        return -1;
    }
}
