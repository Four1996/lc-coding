package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: first
 * @description: 打乱数组
 * @author: panhao
 * @date: 2021-07-24 20:45
 **/
public class Shuffle_n384 {
    int[] dumy;
    int[] nums;

    public Shuffle_n384(int[] nums) {
        this.nums = nums;
        dumy = Arrays.copyOfRange(nums, 0, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        dumy = Arrays.copyOfRange(nums, 0, nums.length);
        return dumy;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int len = dumy.length;
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            int num = r.nextInt(dumy.length) % (dumy.length + 1);
            if (i != num) {
                int temp = dumy[i];
                dumy[i] = dumy[num];
                dumy[num] = temp;
            }
        }
        return dumy;
    }
}
