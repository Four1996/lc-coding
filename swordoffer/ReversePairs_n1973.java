package leetcode.swordoffer;

import test.ProxyTest.Lenovo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author panhao
 * @date 2021年06月03日 9:16 下午
 */
public class ReversePairs_n1973 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] dumy = new int[len];
        for (int i = 0; i < len; i++) {
            dumy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(nums, 0, len - 1, temp);
    }

    private int reversePairs(int[] dumy, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(dumy, left, mid, temp);
        int rightCount = reversePairs(dumy, mid + 1, right, temp);
//        如果左右两边数组已经是整体有序了，那么就不用再进行合并了，直接返回就行了。
        if (dumy[mid]<=dumy[mid+1]) return leftCount+rightCount;
        int countPairs = mergeArray(dumy, left, mid, right, temp);
        return leftCount + rightCount + countPairs;
    }

    int mergeArray(int[] nums, int left, int mid, int right, int[] temp) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int k = left;
        int i = left;
        int j = mid + 1;
        for (; k <= right && i <= mid && j <= right; k++) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += mid - i + 1;
            }
        }
        while (i <= mid&&k<=right) nums[k++] = temp[i++];
        while (j <= right&&k<=right) nums[k++] = temp[j++];
        return count;
    }

    public static void main(String[] args) {
        int[] nums={7,5,6,4};
        System.out.println(new ReversePairs_n1973().reversePairs(nums));
    }
}
