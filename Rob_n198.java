package leetcode;

/**
 * @author panhao
 * @date 2021年04月15日 10:17 上午
 */
public class Rob_n198 {
    public int rob(int[] nums){
        int len=nums.length;
        if (len==1) return nums[0];
        int pre=0,cur=0,tmp=0;
        for (int i=0;i<len;i++){
            tmp=cur;
            cur=Math.max(pre+nums[i],cur);
            pre=tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Rob_n198 rob_n198=new Rob_n198();
        int[] nums={0};
        System.out.println(rob_n198.rob(nums));
    }
}
