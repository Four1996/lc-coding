package leetcode;

/**
 * @author panhao
 * @date 2021年05月12日 8:09 上午
 */
public class XorQueries_n1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len= queries.length;
        int[] ans=new int[len];
        for (int i=0;i<len;++i){
            int left=queries[i][0];
            int right=queries[i][1];
            int xor=0;
            for (int j=left;j<=right;++j){
                xor^=arr[j];
            }
            ans[i]=xor;
        }
        return ans;
    }
}
