package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月09日 11:57 上午
 */
public class MaxSumMinProduct_n5752 {
    int[] nums;
    int lowbit(int x){
        return x&(-x);
    }
    int query(int x){
        int sum=0;
        while (x!=0){
            sum+=nums[x];
            x-=lowbit(x);
        }
        return sum;
    }
    void add(int x,int val){
        while (x<nums.length){
            nums[x]+=val;
            x+=lowbit(x);
        }
    }
    public int maxSumMinProduct(int[] _nums) {
        nums=new int[_nums.length+1];
        for (int i=1;i<nums.length;++i){
            add(i,_nums[i-1]);
        }
        int window_size=1,max=0;
        int left=0,right=left+window_size;
        while (window_size<=_nums.length&&right<_nums.length){
            while (right<=_nums.length){
                int[] window=new int[window_size];
                int cur=0;
                for (int i=left;i<=right&&cur<window_size;){
                    window[cur]=_nums[i];
                    cur++;
                    i++;
                }
                Arrays.sort(window);
                int mul=window[0]*(query(right)-query(left));
                max=Math.max(max,mul);
                left++;
                right=left+window_size;
            }
            window_size++;
            left=0;
            right=left+window_size;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={4,10,6,4,8,7,8,3,5,3,4,9,9,5,10,7,10,7,6,4};
        MaxSumMinProduct_n5752 m=new MaxSumMinProduct_n5752();
        System.out.println(m.maxSumMinProduct(nums));
    }


}
