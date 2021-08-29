package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-29 10:51
 **/
public class MinSessions_5856 {
    public static int minSessions(int[] tasks, int sessionTime) {
        int ans=0;
        int len=tasks.length;
        Arrays.sort(tasks);
        int left=0,right=len-1;
        int count=0;
        while (count<len){
            left=0;
            int diff=sessionTime;
            while (right>=left&&diff>=tasks[right]){
                diff-=tasks[right];
                count++;
                right--;
            }
            while (left<=right&&diff>=tasks[left]){
                left++;
            }
            left--;
            while (left>=0){
                if (diff>=tasks[left]&&tasks[left]!=-1){
                    diff-=tasks[left];
                    count++;
                    tasks[left]=-1;
                }
                left--;
            }
            ans++;

        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={1,5,7,10,3,8,4,2,6,2};
        System.out.println(minSessions(nums,10));
    }
}
