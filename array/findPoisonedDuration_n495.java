package leetcode.array;

/**
 * @program: first
 * @description: 提莫攻击
 * @author: panhao
 * @date: 2021-11-10 17:48
 **/
public class findPoisonedDuration_n495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (timeSeries[i] > timeSeries[i - 1] + duration - 1) {
                ans += duration;
            } else {
                ans += timeSeries[i] - timeSeries[i - 1];
            }
        }
        ans += duration;
        return ans;
    }
}
