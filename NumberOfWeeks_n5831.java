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
        int len = milestones.length;
        long week = 0;
        Arrays.sort(milestones);
        int left = 0, right = len - 1;
        while (left < right) {
            if (milestones[left] < milestones[right]) {
                week += (milestones[left] * 2L);
                milestones[right] -= milestones[left];
                milestones[left] = 0;

                left++;
            } else if (milestones[left] == milestones[right]) {
                week += (milestones[left] * 2L);
                milestones[left] = 0;
                milestones[right] = 0;
                left++;
                right--;
            } else if (milestones[left] > milestones[right]) {
                week += (milestones[right] * 2L);
                milestones[left] -= milestones[right];
                milestones[right] = 0;
                right--;

            }
        }
        if (milestones[right] > 0 || milestones[left] > 0) week++;
        return week;
    }

    public static void main(String[] args) {
        int[] nums={9,7,7,7,5,5};
        System.out.println(numberOfWeeks(nums));
    }
}
