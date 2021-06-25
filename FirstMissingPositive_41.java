package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月30日 10:13 上午
 */
public class FirstMissingPositive_41 {
    public static int firstMissingPositive(int[] nums){
        int len=nums.length;
        int cur=1;
        Arrays.sort(nums);
        for (int i=0;i<len;i++){
            if (nums[i]>=1){
                if (nums[i]==cur){
                    cur++;
                }else{
                    if (nums[i]!=cur&&nums[i]>cur) return cur;
                }
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums={7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }
}
