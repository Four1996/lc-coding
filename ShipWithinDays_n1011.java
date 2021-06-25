package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月26日 8:48 上午
 */
public class ShipWithinDays_n1011 {
    public int shipWithinDays(int[] weights,int D){
        int len=weights.length;
        int left=0,right=0;
        for (int i=0;i<len;i++){
            left=left>weights[i]?left:weights[i];
            right+=weights[i];
        }
        while (left<right){
            int mid=(left+right)/2;
            int day=1,cur=0;
            for (int ele:weights){
                if (cur+ele>mid){
                    day++;
                    cur=0;
                }
                cur+=ele;
            }
//            if(day<=D) right=mid;//为什么不是right=mid-1，left=mid呢，因为当出现一个mid使得它=left的时候，
//                // 正好它使day>D，则会进入else left=mid，那么这个时候就会死循环。
//            else left=mid+1;
            if (day>D) left=mid+1;
            else right=mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={3,2,2,4,1,4};
        ShipWithinDays_n1011 s=new ShipWithinDays_n1011();
        System.out.println(s.shipWithinDays(nums,3));
    }
}
