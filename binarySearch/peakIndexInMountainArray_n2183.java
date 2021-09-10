package leetcode.binarySearch;

/**
 * @program: first
 * @description: 山峰数组的顶部
 * @author: panhao
 * @date: 2021-09-10 21:29
 **/
public class peakIndexInMountainArray_n2183 {
    public static int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right + 1) >> 1;
            if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={3,5,3,2,0};
        System.out.println(peakIndexInMountainArray(nums));
    }
}
