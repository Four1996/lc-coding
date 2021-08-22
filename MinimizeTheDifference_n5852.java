package leetcode;

import java.awt.font.FontRenderContext;
import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-22 10:53
 **/

public class MinimizeTheDifference_n5852 {
    int ans = Integer.MAX_VALUE;
    int row, col;
    public int minimizeTheDifference(int[][] mat, int target) {
        row = mat.length;
        col = mat[0].length;
        int min=0,max=0;
        for (int i = 0; i < row; i++) {
            Arrays.sort(mat[i]);
            min+=mat[i][0];
            max+=mat[i][col-1];
        }
        if (min==max){
            return Math.abs(target-min);
        }
        if (row==1){
            int left=0,right=col-1;
            while (left<right){
                int mid=(left+right)>>1;
                if (mat[0][mid]>=target){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            return Math.abs(mat[0][left]-target);
        }
        int left=min,right=max;
        while (left<=right){
            int mid=(left+right)>>1;
            if (check(mat,mid-min)){
                ans=Math.min(Math.abs(mid-target),ans);
            }
            if (mid>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    public boolean check(int[][] mat,int search) {
        if (search==0){
            return true;
        }
        for (int i=0;i<row;i++){
            while (i<row&&(search<mat[i][0]||search>mat[i][col-1])){
                i++;
            }
            if (i==row){
                break;
            }
            for (int j=0;j<col;j++){
                if (mat[i][j]==search){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                // {7,8,9,4,8,5,8,9},
                // {9,6,8,8,6,10,9,8},
                // {8,4,6,3,10,5,8,5},
                // {5,9,9,9,9,10,10,7},
                // {5,4,8,9,6,10,2,6},
                // {1,4,2,1,10,1,5,10}
                // {1,2,9,8,7}
                {3,5},{5,10}
        };
        System.out.println(new MinimizeTheDifference_n5852().minimizeTheDifference(mat, 47));
    }
}
