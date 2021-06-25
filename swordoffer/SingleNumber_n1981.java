package leetcode.swordoffer;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年06月04日 9:51 下午
 */
public class SingleNumber_n1981 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int pre=nums[0],cur;
        for (int i = 1; i < nums.length;) {
            cur=nums[i];
            if (pre!=cur)return pre;
            i+=3;
            pre=nums[i-1];
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums={9,1,7,9,7,9,7};
        System.out.println(new SingleNumber_n1981().singleNumber(nums));
    }
}
