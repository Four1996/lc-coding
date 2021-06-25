package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年05月08日 4:33 下午
 */
public class MinArray_n1899 {
    public static int minArray(int[] numbers) {
        if (numbers.length==1) return numbers[0];
        int left=0,right=numbers.length-1;
        while (numbers[left+1]==numbers[left]){
            left++;
            if (left== numbers.length-1) break;
        }
        if (left==numbers.length-1) return numbers[0];
        while (numbers[right]==numbers[right-1]){
            right--;
            if (right<0) break;
        }
        if (right<0) return numbers[0];
        if (right==left+1) return numbers[right]<numbers[left]?numbers[right]:numbers[left];
        int lleft=left,rright=right;
        while (left<right){
            int mid=(left+right+1)/2;
            if (numbers[mid]<=numbers[0]) right=mid-1;
            else left=mid;
        }
        if (left==rright) return numbers[lleft];
        if (numbers[left]>=numbers[lleft]) return numbers[++left];
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={0,1,2,2,2,2};
        System.out.println(minArray(nums));
    }
}
