package leetcode.dp;

import test.reflect.domain.Person;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: first
 * @description: 救生艇
 * @author: panhao
 * @date: 2021-08-26 09:13
 **/
public class NumRescueBoats_n881 {
    public static int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int len = people.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;

            }
            right--;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={5,1,4,2};
        System.out.println(numRescueBoats(nums,6));
    }
}
