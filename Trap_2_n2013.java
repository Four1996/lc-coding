package leetcode;

/**
 * @author panhao
 * @date 2021年04月02日 9:34 下午
 */
public class Trap_2_n2013 {
    public static int trap(int[] height){
        int area=0;
        int high=1;
        int left=0,right=height.length-1;
        if (height.length<3) return 0;
        int max=0;
        for (int i=0;i<height.length;i++){
            if (max<=height[i]) max=height[i];
        }
        while (left<=right&&high<=max){
            while(high>height[left]&&left<=right){
                left++;
            }
            while(high>height[right]&&left<=right){
                right--;
            }
            area+=right-left+1;
            high++;
        }
        for(int i=0;i<height.length;i++){
            area-=height[i];
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height={0,2,0};
        System.out.println(trap(height));
    }
}
