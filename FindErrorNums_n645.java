package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月30日 9:30 上午
 */
public class FindErrorNums_n645 {
    public static int[] findErrorNums(int[] nums){
        int len=nums.length;
        Arrays.sort(nums);
        int pre=nums[0];
        int cur=0;
        for (int i=1;i<len;i++){
            cur=nums[i];
            if (pre==cur){
                nums[i]=-1;
                Arrays.sort(nums);
                break;
            }
            pre=cur;
        }
        for (int i=1;i<len;i++){
            if (nums[i]!=i) return new int[]{cur,i};
        }
        return new int[]{cur,nums[len-1]+1};
    }

    public static void main(String[] args) {
        int[] nums={1,1};
        for (int i:findErrorNums(nums)){
            System.out.println(i);
        }
    }
}
