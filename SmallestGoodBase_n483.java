package leetcode;

/**
 * @program: first
 * @description: 最小好进制
 * @author: panhao
 * @date: 2021-06-18 09:09
 **/
public class SmallestGoodBase_n483 {

    public String smallestGoodBase(String n) {
        long nval=Long.valueOf(n);
        int mMax= (int) Math.floor(Math.log(nval)/Math.log(2));
        for (int m=mMax;m>=2;m--){
            int k= (int) Math.pow(nval,1.0/m);
            long mul=1,sum=1;
            for (int i=0;i<m;i++){
                mul*=k;
                sum+=mul;
            }
            if (sum==nval){
                return Integer.toString(k);
            }
        }
        return Long.toString(nval-1);
    }
}
