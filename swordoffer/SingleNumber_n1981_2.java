package leetcode.swordoffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月04日 9:51 下午
 */
public class SingleNumber_n1981_2 {
    public int singleNumber(int[] nums) {

        int ans=0;
        for (int i=30;i>=0;i--){
            int n=0;
            for (int num1 : nums) {
                n+=num1>>i&1;
            }
            ans=(ans<<1)+(n%3);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums={9,1,7,9,7,9,7};
        System.out.println(new SingleNumber_n1981_2().singleNumber(nums));
    }
}
