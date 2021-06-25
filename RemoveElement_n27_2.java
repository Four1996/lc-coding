package leetcode;

/**
 * @author panhao
 * @date 2021年04月13日 2:23 下午
 */
public class RemoveElement_n27_2 {
    public static int removeElement(int[] nums,int val){
        int len=nums.length;
        if (len==0) return 0;
        int ans=0;
        for (int i=0;i<len;i++){
            if (nums[i]!=val){
                nums[ans]=nums[i];
                ans++;
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
        int[] nums={3,2,2,3,4};
        System.out.println(removeElement(nums,3));
    }
}
