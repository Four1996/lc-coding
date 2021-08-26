package leetcode.sort;

/**
 * @program: first
 * @description: 归并排序————二路
 * @author: panhao
 * @date: 2021-08-26 10:12
 **/
public class mergeSort_n912 {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 创建全局的临时数组，用于合并两个有序数组的copy，避免额外的开销。
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 如果当前每一路只剩一个元素，天然有序，直接返回即可。
        if (left == right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        // 如果已经有序，直接跳过合并。
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                // 左边的全部安放完毕
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                // 右边的全部安放完毕
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 如果写成<,那么将失去稳定性（既保证原来在前面的，还要在前面）
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }
}
