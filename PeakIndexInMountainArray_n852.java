package leetcode;

/**
 * @author panhao
 * @date 2021年04月14日 4:27 下午
 */
public class PeakIndexInMountainArray_n852 {
    public int peakIndexInMountainArray(int[] arr){
        int len=arr.length;
        if (len<3) return -1;
        int left=0,right=len-1;
        while(left<=right){
            int mid=left+(right-left+1)/2;
            if (arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]) return mid;
            if (arr[mid]>arr[mid-1]&&arr[mid]<arr[mid+1]) left=mid+1;//如果在山峰左边
            if (arr[mid]<arr[mid-1]&&arr[mid]>arr[len-1]) right=mid-1;//如果在山峰右边
        }
        return -1;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray_n852 peakIndexInMountainArray_n852=new PeakIndexInMountainArray_n852();
        int[] nums={24,69,100,99,79,78,67,36,26,19};
        System.out.println(peakIndexInMountainArray_n852.peakIndexInMountainArray(nums));
    }
}
