package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-01 10:34
 **/
public class NumberOfWeeks_n5831 {
    public static long numberOfWeeks(int[] milestones) {

        Arrays.sort(milestones);
        long max=milestones[milestones.length-1];
        long sum=0;
        for (int milestone : milestones) {
            sum+=milestone;
        }
        long rest=sum-max;
        if (max>rest){
            return rest*2+1;
        }
        else return sum;
    }

    public static void main(String[] args) {
        int[] nums={9,7,7,7,5,5};
        System.out.println(numberOfWeeks(nums));
    }
}
