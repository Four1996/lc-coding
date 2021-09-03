package leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: first
 * @description: 最小时间差
 * @author: panhao
 * @date: 2021-09-03 15:11
 **/
public class FindMinDifference_n2140 {
    public static int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[][] nums = new int[len][2];
        int idx = 0;
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            nums[idx][0] = Integer.parseInt(split[0]);
            nums[idx][1] = Integer.parseInt(split[1]);
            idx++;
        }
        Arrays.sort(nums, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int diffHour = nums[i + 1][0] - nums[i][0];
            int diffMin = nums[i + 1][1] - nums[i][1];
            int all = diffHour * 60 + diffMin;
            ans = Math.min(ans, all);
            if (ans == 0) {
                return 0;
            }
        }
        int diffHour = 23 - nums[len - 1][0] + nums[0][0];
        int diffMin = 60 - nums[len - 1][1] + nums[0][1];
        ans = Math.min(ans, diffMin + diffHour * 60);
        return ans;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("01:01");
        list.add("02:01");
        System.out.println(findMinDifference(list));
    }
}
