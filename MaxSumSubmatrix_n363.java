package leetcode;

import java.util.TreeSet;

/**
 * @author panhao
 * @date 2021年04月22日 9:02 上午
 */
public class MaxSumSubmatrix_n363 {
    public int maxSumSubmatrix(int[][] matrix,int k){
        int ans=Integer.MIN_VALUE;
        int row=matrix.length,col=matrix[0].length;
        for (int i=0;i<row;i++){//模拟上边界
            int[] sum=new int[col];
            for (int j=i;j<row;j++){//模拟下边界
                for (int c=0;c<col;c++){
                    sum[c]+=matrix[j][c];//更新每列的元素和
                }
                TreeSet<Integer> sumset=new TreeSet<>();
                sumset.add(0);
                int s=0;
                for (int v:sum){
                    s+=v;
                    Integer ceil=sumset.ceiling(s-k);
                    if (ceil!=null){
                        ans=Math.max(ans,s-ceil);
                    }
                    sumset.add(s);
                }
            }
        }
        return ans;
    }
}
