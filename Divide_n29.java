package leetcode;

/**
 * @author panhao
 * @date 2021年04月08日 11:01 上午
 */
public class Divide_n29 {
    public static int divide(int divided,int divisor){
        long ans=0;
        if (divided==0) return 0;
        if (divisor==1) return divided;
        if(divisor==-1){
            return divided>Integer.MIN_VALUE?-divided:Integer.MAX_VALUE;
        }
        long a=divided;
        long b=divisor;
        boolean tag=true;//false代表负数，true代表整数
        if ((a>0&&b<0)||(a<0&&b>0)) {
            tag=false;
        }
        a=a>0?a:-a;
        b=b>0?b:-b;
        ans=div(a,b);
        if (tag) return (int) ans;
        else return (int) -ans;

    }
    static int div(long a,long b){
        if (a<b) return 0;
        int count=1;//结果至少是1
        long median=b;
        while ((median+median)<a){
            count+=count;
            median+=median;
        }
        return count+div(a-median,b);
    }

    public static void main(String[] args) {
        int divided=-2147483648,divisor=-1;
        System.out.println(divide(divided,divisor));
    }
}
