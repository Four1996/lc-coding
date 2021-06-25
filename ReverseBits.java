package leetcode;

import java.util.Arrays;

public class ReverseBits {
//    public static int reverseBits(int n){
//
//        String str=Integer.toBinaryString(n);
//        String[] numstr=str.split("");
//        for (int i=0,j=numstr.length;i!=j;i++,j--){
//            String str_num=numstr[i];
//            numstr[i]=numstr[j-1];
//            numstr[j-1]=str_num;
//        }
//        int b_num=Integer.parseInt(str);
//        return n;
//    }
    public static int reverseBits(int n){
        int ans=0;
        for (int i=0;i<32;i++){
            int t=(n>>i)&1;
            if (t == 1) {
                ans|=(1<<(31-i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=43261596;
        reverseBits(n);
    }
}
