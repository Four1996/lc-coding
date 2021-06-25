package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月09日 7:59 上午
 */
public class MinDays_n1482 {
    public static int minDays(int[] bloomDay, int m, int k) {
        int len=bloomDay.length;
        if (len<m*k) return -1;
        int left=1,right=1;
        for (int i:bloomDay){
            right=Math.max(i,right);
        }
        while (left<right){
            int mid=(left+right)/2;
            if (isSuccess(bloomDay,mid,m,k)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static boolean isSuccess(int[] bloomDay,int days,int m,int k){
        int sum=0,flowers=0;
        for (int i=0;i<bloomDay.length;++i){
            if (bloomDay[i]<=days){
                flowers++;
                if (flowers==k){
                    flowers=0;
                    sum++;
                }
            }else {
                flowers=0;
            }
        }
        return sum>=m;
    }

    public static void main(String[] args) {
        int[] nums={7,7,7,7,12,7,7};
        System.out.println(minDays(nums,2,3));
    }
}
