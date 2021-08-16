package leetcode.math;

/**
 * @program: first
 * @description: 快速乘
 * @author: panhao
 * @date: 2021-08-07 20:52
 **/
public class FastMutil {
    public static int fastMutil(int a,int b){
        int ans=0;
        while (b!=0){
            if ((b&1)!=0){
                ans+=a;
            }
            a+=a;
            b>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastMutil(2,11));
    }
}
