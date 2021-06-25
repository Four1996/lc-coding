package leetcode;

/**
 * @author panhao
 * @date 2021年04月14日 9:57 上午
 */
public class Search_n33_2 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > nums[0]) left = mid;
            else right = mid - 1;
        }
        int k = left;
        if (target >=nums[0]) {
            left = 0;
            right = k;
            while (left <= right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        } else {
            left=k;
            right=len-1;
            while (left<=right){
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search_n33_2 search_n33_2=new Search_n33_2();
        int[] nums={1,3};
        System.out.println(search_n33_2.search(nums,1));
    }
}
