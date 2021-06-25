package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author panhao
 * @date 2021年05月16日 9:33 下午
 */
public class FindMaximumXOR_421 {
    static final int High_BIT=30;
    public static int findMaximumXOR(int[] nums) {
        int x=0;
        int len=nums.length;
        for (int i=High_BIT;i>=0;i--){
            Set<Integer> set=new HashSet<>();
            for (int u:nums){
                set.add(u>>i);
            }
            int xnext=x*2+1;
            boolean found=false;
            for (int u:nums){
                if (set.contains(xnext^(u>>i))){
                    found=true;
                    break;
                }
            }
            if (found){
                x=xnext;
            }else{
                x=xnext-1;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums={3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));
    }
}
