package leetcode;

/**
 * @author panhao
 * @date 2021年05月05日 3:15 下午
 */
public class MaxProduct_n152 {
    public static int maxProduct(int[] nums) {
        int len=nums.length;
        int max=Integer.MIN_VALUE,imax=1,imin=1;
        for (int i=0;i<len;i++){
            if (nums[i]<0){
                int temp=imax;
                imax=imin;
                imin=temp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);
            max=Math.max(max,imax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
