package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月09日 10:30 上午
 */
public class MaxinumPopulation_n5750 {
    public static int maximumPopulation(int[][] logs) {
        int[][] nums=new int[logs.length][2];
        int minyear=Integer.MAX_VALUE;
        int[][] ans=new int[1][2];
        ans[0][0]=1;
        ans[0][1]=minyear;
        for (int i=0;i<logs.length;i++){
            nums[i][0]=logs[i][0];
            nums[i][1]=1;
            for (int j=0;j< logs.length;j++){
                if (j!=i){
                    if (logs[i][0]<logs[j][1]&&logs[i][0]>=logs[j][0]) {
                        nums[i][1]++;
                    }
                }
            }
            if (nums[i][1]>=ans[0][0]) {
                if (nums[i][1]>ans[0][0]){
                    ans[0][0]=nums[i][1];
                    ans[0][1]=nums[i][0];
                }else{
                    ans[0][0]=nums[i][1];
                    if (nums[i][0]<ans[0][1]) ans[0][1]=nums[i][0];
                }
            }

        }

        return ans[0][1];
    }

    public static void main(String[] args) {
        int[][] nums={
                {2017,2038},{2001,2013},{2032,2044},{1978,2031},{1950,1973},{2043,2045},{2028,2049},{1979,2042},{2037,2048},{2048,2049},{1980,2021},{2047,2050},{1985,2014},{2028,2031},{1989,2009},{1956,1966},{2014,2043},{1993,2029},{1970,2036},{2013,2044}
        };
        System.out.println(maximumPopulation(nums));
    }
}
