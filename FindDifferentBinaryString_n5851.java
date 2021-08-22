package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-22 10:34
 **/
public class FindDifferentBinaryString_n5851 {
    public static String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=Integer.parseInt("0",2);
        String pre=nums[0];
        for (int i=0;i<n;i++) {
            if (i > 0 && nums[i].equals(pre)) {
                continue;
            }
            int num = Integer.parseInt(nums[i], 2);
            if (ans != num) {
                break;
            }
            pre = nums[i];
            ans++;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(Integer.toBinaryString(ans));
        while (sb.length()<n){
            sb.insert(0,"0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] nums={
                "111","011","001"
        };
        System.out.println(findDifferentBinaryString(nums));
    }

}
