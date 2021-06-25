package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月29日 9:15 上午
 */
public class NumSubmatrixSumTarget_n1074_2 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans=0;
        int row=matrix.length,col=matrix[0].length;
        for (int i=0;i<row;i++){
            int[] sum=new int[col];
            for (int j=i;j<row;j++){
                for (int k=0;k<col;k++){
                    sum[k]+=matrix[j][k];
                }
                ans+=subarraySum(sum,target);
            }
        }
        return ans;
    }
    public int subarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int pre=0;
        for (int num : nums) {
            pre+=num;
            if (map.containsKey(pre-k)) count+=map.get(pre-k);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

}
