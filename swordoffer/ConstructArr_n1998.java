package leetcode.swordoffer;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年06月06日 8:55 下午
 */
public class ConstructArr_n1998 {
    public static int[] constructArr(int[] a) {
        int len=a.length;
        if (len==0) return a;
        int[] b=new int[len];
        b[0]=1;
        for (int i=1;i<len;i++){
            b[i]=b[i-1]*a[i-1];
        }
        int temp=1;
        for (int i=len-2;i>=0;i--){
            temp*=a[i+1];
            b[i]*=temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a={};
        for (int i : constructArr(a)) {
            System.out.println(i);
        }
    }
}
