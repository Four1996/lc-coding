package leetcode;

/**
 * @author panhao
 * @date 2021年04月25日 10:31 上午
 */
public class SumBase_n5738 {
    public int sumBase(int n,int k){
        int k_num=0;
        while (n!=0){
            k_num+=n%k;
            n=n/k;
        }
        return k_num;
    }

    public static void main(String[] args) {
        SumBase_n5738 s=new SumBase_n5738();
        System.out.println(s.sumBase(10,10));
    }
}
