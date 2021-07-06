package leetcode.dp;

/**
 * @program: first
 * @description: 跳跃游戏
 * @author: panhao
 * @date: 2021-07-06 21:34
 **/
public class CanJump_n55 {
    public static boolean canJump(int[] nums) {
        int len=nums.length;
        if (len<2) return true;
        int max=0;
        for (int i=0;i<len;i++){
            if (i>max) return false;
            max=Math.max(max,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={0,2,3};
        System.out.println(canJump(nums));
    }
}
