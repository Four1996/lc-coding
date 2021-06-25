package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月17日 8:36 下午
 */
public class FindRepeatNumber_n1865 {
    public int findRepeatNumber(int[] nums){
        int len=nums.length;
        if (len<2) return -1;
        int u=nums[0];
        Arrays.sort(nums);
        for (int i=1;i<len;i++){
            if (u==nums[i]) return u;
            u=nums[i];
        }
        return -1;
    }
}
