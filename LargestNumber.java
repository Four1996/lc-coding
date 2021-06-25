package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
//import java.util.Random;

/**
 * @author panhao
 * @date 2021年04月12日 9:47 上午
 */
public class LargestNumber {
    public static String largestNumber(int[] nums){
        String maxstr="";
        int len=nums.length;
        if (len==0) return null;
        String[] str=new String[len];
//        Queue<String> queue=new ArrayDeque<>();//用来存放已经有序的字符串
        for (int i=0;i<len;i++){
            str[i]=String.valueOf(nums[i]);
        }
        int low=0,high=len-1;
        if(low<high){
            quickSort(str,low,high);
        }
        for (int i=0;i<len;i++){
            maxstr+=str[i];
        }
        return maxstr;
//        int n = preXOR.length;
//        String[] ss = new String[n];
//        for (int i = 0; i < n; i++) ss[i] = "" + preXOR[i];
//        Arrays.sort(ss);
//        Arrays.sort(ss, (a, b) -> {
//            String sa = a + b, sb = b + a ;
//            return sb.compareTo(sa);
//        });
//
//        StringBuilder sb = new StringBuilder();
//        for (String s : ss) sb.append(s);
//        int len = sb.length();
//        int k = 0;
//        while (k < len - 1 && sb.charAt(k) == '0') k++;
//        return sb.substring(k);

    }
    static void quickSort(String[] str,int low,int high){
        if (low<high){
            int privot=partition(str,low,high);
            quickSort(str,low,privot-1);
            quickSort(str,privot+1,high);
        }
    }
    public static int partition(String[] str,int low,int high){
        String flag=str[0];
        while(low<high){
            while ((low<high&&str[high].compareTo(flag)<=0)) high--;
            str[low]=str[high];
            while (low<high&&str[low].compareTo(flag)>0) low++;
            str[high]=str[low];
        }
        str[low]=flag;
        return low;
    }

    public static void main(String[] args) {
        int[] nums={3,30,34,5,9};
        System.out.println(largestNumber(nums));
        String a1="9",a2="92";
        System.out.println(a1.compareTo(a2));
    }
}
