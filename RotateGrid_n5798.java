package leetcode;

import leetcode.classic.Roate_n2029;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 循环轮转矩阵
 * @author: panhao
 * @date: 2021-06-27 20:39
 **/
public class RotateGrid_n5798 {
    int m, n;

    public int[][] rotateGrid(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int separates = Math.min(m, n) / 2;
        for (int i = 0; i < separates; i++) {
            int counts = (m - (i * 2)) * 2 + (n - (i * 2)) * 2 - 4;
            int[] nums = getReverse(getNums(grid, i, counts), k);
            getGrid(grid,i,nums);
        }
        return grid;
    }
    public void getGrid(int[][] grid,int sep,int[] nums){
        int counts=nums.length;
        int row=m-sep,col=n-sep;
        int idx=0;
        int i=sep,j=sep;
        while (idx<counts&&i<row&&j<col){
            while (idx<counts&&j<col){
                grid[i][j]=nums[idx++];
                j++;
            }
            j--;
            i++;
            while (idx < counts && i < row) {
                grid[i][j]=nums[idx++];
                i++;
            }
            i--;
            j--;
            while (idx < counts && j >= sep) {
                grid[i][j]=nums[idx++];
                j--;
            }
            j++;
            i--;
            while (idx < counts && i > sep) {
                grid[i][j]=nums[idx++];
                i--;
            }
        }
    }
    public int[] getNums(int[][] grid, int sep, int counts) {
        int[] nums = new int[counts];
        int row = m - sep, col = n - sep;
        int idx = 0;
        int i = sep, j = sep;
        while (idx < counts && i < row && j < col) {
            while (idx < counts && j < col) {
                nums[idx++] = grid[i][j];
                j++;
            }
            j--;
            i++;
            while (idx < counts && i < row) {
                nums[idx++] = grid[i][j];
                i++;
            }
            i--;
            j--;
            while (idx < counts && j >= sep) {
                nums[idx++] = grid[i][j];
                j--;
            }
            j++;
            i--;
            while (idx < counts && i > sep) {
                nums[idx++] = grid[i][j];
                i--;
            }
        }
        return nums;
    }

    public int[] getReverse(int[] nums, int k) {
        int len = nums.length;
        int size=k%len;
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < len - size; i++) {
            nums[i] = nums[i + size];
        }
        for (int i = len - size, j = 0; i < len && j < size; i++, j++) {
            nums[i] = temp[j];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5};
        int[][] grid={
                {40,10},
                {30,20}
        };
        System.out.println(new RotateGrid_n5798().rotateGrid(grid, 1));
    }
}
