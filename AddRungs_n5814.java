package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-18 10:35
 **/
public class AddRungs_n5814 {
    public static int addRungs(int[] rungs, int dist) {
        int len = rungs.length;
        int ans = 0;
        int step = 0;
        for (int i = 0; i < len; i++) {
            if (step + dist < rungs[i]) {
                int diff = rungs[i] - 1 - step;
                int count = diff / dist;
                ans += count;
            }
            step = rungs[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 10};
        System.out.println(addRungs(nums, 2));
    }
}
