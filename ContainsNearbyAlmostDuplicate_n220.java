package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author panhao
 * @date 2021年04月17日 11:06 上午
 */
public class ContainsNearbyAlmostDuplicate_n220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = nums[i] * 1L;
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if(l != null && u - l <= t) return true;
            if(r != null && r - u <= t) return true;
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= k) ts.remove(nums[i - k] * 1L);
        }
        return false;

    }
//    static boolean binarySearch(int preXOR[],int t){
//        int left=0,right=preXOR.length-1;
//        while (left<=right){
//            int mid=left+(right-left+1)/2;
//            if ((Math.abs(preXOR[mid]-preXOR[mid-1])<=t)||Math.abs(preXOR[mid]-preXOR[mid+1])<=t) break;
//                left=mid;
//            else right=mid-1;
//        }
//        if (left==preXOR.length-1){
//            if (Math.abs(preXOR[left] - preXOR[left - 1]) <= t) return true;
//            else return false;
//        }
//        if (Math.abs(preXOR[left] - preXOR[left + 1]) <= t) return true;
//        else return false;
//    }

    public static void main(String[] args) {
//        int preXOR[]={1,5,9,1,5,9};
        int nums[]={1,2,2,3,1};
//        int preXOR[]={1,2,3,1};
//        int preXOR[]={1,0,1,1};
//        int preXOR[]={1,2,1,1};
        System.out.println(containsNearbyAlmostDuplicate(nums,3,0));
    }
}
