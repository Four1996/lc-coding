package leetcode;

/**
 * @program: first
 * @description: 颜色分类
 * @author: panhao
 * @date: 2021-07-04 20:03
 **/
public  class SortColors_n75 {
    public static void sortColors(int[] nums) {
        int num0=0,num1=0,num2=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                nums[num2++]=2;
                nums[num1++]=1;
                nums[num0++]=0;
            }else if (nums[i]==1){
                nums[num2++]=2;
                nums[num1++]=1;
            }else{
                nums[num2++]=2;
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        sortColors(nums);
    }
}
