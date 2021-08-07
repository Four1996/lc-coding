package leetcode.array;

/**
 * @program: first
 * @description: 环形数组是否存在循环
 * @author: panhao
 * @date: 2021-08-07 09:44
 **/
public class CircularArrayLoop_n457_2 {

    public static boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        int[] vis = new int[len];
        for (int start = 0, idx = 1; start < len; start++, idx++) {
            if (vis[start] != 0) continue;
            int cur = start;
            boolean postive = nums[cur] > 0;
            while (true) {
                int next = ((cur + nums[cur]) % len + len) % len;
                // 代表形成了自环，此时环的长度一定是等于1的，不满足题意，所以直接跳出。
                if (next == cur) break;

                if (vis[next] != 0) {
                    if (vis[next] != idx) break;
                    else return true;
                }
                if (postive && nums[next] < 0) break;
                if (!postive && nums[next] > 0) break;
                vis[next] = idx;
                cur = next;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums={-1,2};
        System.out.println(circularArrayLoop(nums));
    }
}
