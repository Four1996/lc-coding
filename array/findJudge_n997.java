package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 找到小镇的法官
 * @author: panhao
 * @date: 2021-12-19 21:45
 **/
public class findJudge_n997 {
    public static int findJudge(int n, int[][] trust) {
        int[][] nums = new int[n + 1][2];
        for (int[] ints : trust) {
            nums[ints[0]][0]++;
            nums[ints[1]][1]++;
        }
        for (int i = 1; i <= n; i++) {
            if (nums[i][0] == 0 && nums[i][1] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] nums={{1,3},{2,3}};
        System.out.println(findJudge(3,nums));
    }
}
