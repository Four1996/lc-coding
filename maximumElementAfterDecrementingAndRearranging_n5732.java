package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年05月01日 11:21 下午
 */
public class maximumElementAfterDecrementingAndRearranging_n5732 {
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0]!=1) arr[0]=1;
        int len=arr.length;
        int max=arr[0];
        for (int i=1;i<len;i++){
            if (Math.abs(arr[i]-arr[i-1])>1){
                arr[i]=arr[i-1]+1;
            }
            max=max>arr[i]?max:arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }
}
