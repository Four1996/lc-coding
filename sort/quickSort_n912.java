package leetcode.sort;

/**
 * @program: first
 * @description: 快排
 * @author: panhao
 * @date: 2021-08-26 10:10
 **/
public class quickSort_n912 {
    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        quickSort(nums, low, high);
        return nums;
    }
    public static void quickSort(int[] nums,int low,int high){
        if (low<high) {
            int cur = partition(nums, low, high);
            if (cur!=-1){
                quickSort(nums, low, cur - 1);
                quickSort(nums, cur + 1, high);
            }
        }
    }
    public static int partition(int[] nums,int low,int high) {
        if (low >= nums.length) {
            return -1;
        }
        int compare = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= compare) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= compare) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = compare;
        return low;
    }

    public static void main(String[] args) {
        int[] nums={5,1,1,2,0,0};
        for (int i : sortArray(nums)) {
            System.out.println(i);
        }
    }
}
