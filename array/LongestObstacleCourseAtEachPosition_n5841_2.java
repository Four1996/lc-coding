package leetcode.array;

import java.util.Arrays;

/**
 * @program: first
 * @description: 优化
 * @author: panhao
 * @date: 2021-08-08 11:28
 **/
public class LongestObstacleCourseAtEachPosition_n5841_2 {
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = obstacles.length;
        int[] ans=new int[len];
        int[] tail=new int[len];
        int end=-1;
        for (int i=0;i<len;i++){
            if (end==-1||obstacles[i]>=tail[end]){
                tail[++end]=obstacles[i];
                ans[i]=end+1;
            }else{
                int left=0,right=end;
                while (left<right){
                    int mid=(left+right)/2;
                    if (tail[mid]<=obstacles[i]){
                        left=mid+1;
                    }else{
                        right=mid;
                    }
                }
                tail[left]=obstacles[i];
                ans[i]=left+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={5,3,4,4,4,2,1,1,4,1};
        System.out.println(Arrays.toString(longestObstacleCourseAtEachPosition(nums)));
    }
}
