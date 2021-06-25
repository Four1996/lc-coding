package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月04日 8:15 下午
 */
public class Search_n1975 {
    public int search(int[] nums, int target) {
        int len=nums.length;
        if (len==0) return 0;
        int count=0;
        int left=0,right=nums.length-1,mid=0;
        while (left<=right){
            mid=left+(right-left)/2;
            if (nums[mid]<target) left=mid+1;
            else if(nums[mid]>target)right=mid-1;
            else{
                break;
            }
        }
        if (nums[mid]==target){
            count++;
            left=mid-1;
            right=mid+1;
            while (left>=0&&nums[left]==target){
                count++;
                left--;
                if (left==-1) break;
            }
            while (right<=len-1&&nums[right]==target){
                count++;
                right++;
                if (right==len) break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(new Search_n1975().search(nums,1));
    }
}
