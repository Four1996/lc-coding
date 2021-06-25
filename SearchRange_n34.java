package leetcode;

/**
 * @author panhao
 * @date 2021年04月14日 9:12 上午
 */
public class SearchRange_n34 {
    public int[] searchRange(int[] nums,int target){
        int[] ans={-1,-1};
        int len=nums.length;
        if (len==0) return ans;
        if (len==1){
            if (nums[0]==target){
                ans[0]=0;
                ans[1]=0;
            }
            return ans;
        }
        int left=0,right=len-1;
        while(left<=right){
            int mid=left+(right-left+1)/2;
            if (nums[mid]==target){
                int ll=mid,lr=mid;
                while(nums[ll]==nums[mid]){
                    if (ll==0)break;
                    ll--;
                }
                if (ll==0&&nums[ll]==nums[mid]) ans[0]=0;
                else ans[0]=++ll;
                while (nums[lr]==nums[mid]){
                    if(lr==len-1) break;
                    lr++;
                }
                if (lr==len-1&&nums[lr]==nums[mid]) ans[1]=len-1;
                else ans[1]=--lr;
            }
            if (nums[mid]>target) right=mid-1;
            else left=mid+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchRange_n34 searchRange_n34=new SearchRange_n34();
        int[] nums={1,2};
        for (int ele:searchRange_n34.searchRange(nums,1)){
            System.out.println(ele);
        }
    }
}
