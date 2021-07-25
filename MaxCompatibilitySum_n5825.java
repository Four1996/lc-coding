package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-25 10:56
 **/
public class MaxCompatibilitySum_n5825 {
    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        HashSet<Integer> set=new HashSet<>();
        for (int i=0;i<mentors.length;i++){
            set.add(i);
        }
        int ans=0;
        for (int i=0;i<students.length;i++){
            int max_sum=0;
            int max_cur=-1;
            for (int j=0;j<mentors.length;j++){
                if (!set.contains(j)) continue;
                int sum=0;
                for (int k=0;k<mentors[j].length;k++){
                    if (students[i][k]==mentors[j][k]) sum++;
                }
                if (sum>max_sum){
                    max_sum=sum;
                    max_cur=j;
                }
            }
            ans+=max_sum;
            set.remove(max_cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] s={
                {0,0,1,1,1,0,1},{0,1,1,0,0,0,0},
        {0,0,1,1,1,1,1},{0,1,0,0,1,0,1},
            {1,0,1,1,1,1,1}
                // {0,0},{0,0},{0,0}
        };
        int[][] m={
                // {1,0,0},{0,0,1},{1,1,0}
                // {1,1},{1,1},{1,1}
                {0,1,1,0,0,0,0},{0,1,0,0,0,0,1},
                {0,1,0,1,0,0,1},{1,0,0,0,1,0,1},
                {1,1,1,1,1,0,0}
        };
        System.out.println(maxCompatibilitySum(s,m));
    }
}
