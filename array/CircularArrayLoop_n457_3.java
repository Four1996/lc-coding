package leetcode.array;

/**
 * @program: first
 * @description: 环形数组是否存在循环
 * @author: panhao
 * @date: 2021-08-07 09:44
 **/
public class CircularArrayLoop_n457_3 {
    static int OFFSET=100010;
    public static boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= OFFSET) continue;
            int cur = i, tag = OFFSET + i, last = -1;
            boolean postive = nums[cur] > 0;
            while (true) {
                int next = ((cur + nums[cur]) % len + len) % len;
                last = nums[cur];
                nums[cur] = tag;
                cur = next;
                if (cur == i) break;
                if (nums[cur] >= OFFSET) break;
                if (postive && nums[cur] < 0) break;
                if (!postive && nums[cur] > 0) break;
            }
            if (last % len != 0 && nums[cur] == tag) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums={-1,2};
        System.out.println(circularArrayLoop(nums));
    }
}
