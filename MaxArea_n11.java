package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description: 盛最多最的容器
 * @author: panhao
 * @date: 2021-07-06 21:00
 **/
public class MaxArea_n11 {
    public int maxArea(int[] height) {
        int ans=0;
        int left=0,right=height.length-1;
        while (left<right){
            int h=Math.min(height[left],height[right]);
            int area=(right-left)*h;
            ans=Math.max(area,ans);
            if (height[left]<height[right]) left++;
            else right--;
        }
        return ans;
    }
}
