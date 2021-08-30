package leetcode;

import java.util.Random;

/**
 * @program: first
 * @description: 按权重随机选择
 * @author: panhao
 * @date: 2021-08-30 14:14
 **/
public class PickIndex_n528 {
    int[] preSum;
    Random r=new Random();
    int total;
    public PickIndex_n528(int[] w) {
        int len=w.length;
        preSum=new int[len+1];
        for (int i = 1; i <=len; i++) {
            preSum[i]=preSum[i-1]+w[i-1];
        }
        total=preSum[len];
    }

    public int pickIndex() {
        // +1是为了不让0出现
        int x= r.nextInt(total)+1;
        return search(x)-1;
    }
    public int search(int x){
        int left=1,right=preSum.length-1;
        while (left<right){
            int mid=(left+right)>>1;
            if (preSum[mid]>=x){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            System.out.println(new Random().nextInt(10)+1);
        }
    }
}
