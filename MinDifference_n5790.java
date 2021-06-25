package leetcode;

import java.util.Queue;

/**
 * @program: first
 * @description: 查询差绝对值的最小值
 * @author: panhao
 * @date: 2021-06-20 15:47
 **/
public class MinDifference_n5790 {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] pre = new int[n+1][101];
        for(int i=0;i<n;i++){
            for(int j=0;j<101;j++)
                pre[i+1][j] = pre[i][j]; // 将前面的前缀信息也记录起来
            pre[i+1][nums[i]]++;
        }
        int size = queries.length;
        int[] ans = new int[size];
        for(int i=0;i<size;i++){
            int left=queries[i][0], right=queries[i][1];
            int minValue=Integer.MAX_VALUE, last=-1;
            for(int j=1;j<=100;j++){
                if(pre[left][j] < pre[right+1][j]){ // 证明存在
                    if(last != -1)
                        minValue = Math.min(minValue, j-last);
                    last = j;
                }
            }
            if(minValue == Integer.MAX_VALUE)
                minValue = -1;
            ans[i] = minValue;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={4,5,2,2,7,10};
        int[][] q=new int[][]{
                {2,3},
                {0,2},
                {0,5},
                {3,5}
        };
        for (int i : new MinDifference_n5790().minDifference(nums, q)) {
            System.out.println(i);
        }
    }
}
