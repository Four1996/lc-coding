package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月03日 3:23 下午
 */
public class FindNthDigit_n1966 {
    public int findNthDigit(int n) {
        long ans;
        long start=1;
        long cur=1;
        long count=start*cur*9;
        while (n>count){
            n-=count;
            cur++;
            start*=10;
            count=start*cur*9;
        }
        int j= (int) (n/cur),k= (int) (n%cur);
        ans=start+j-1;
        String str=String.valueOf(ans);
        if (k==0) return str.charAt(str.length()-1)-'0';
        else {
            str=String.valueOf(ans+1);
            return str.charAt(k-1)-'0';
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit_n1966().findNthDigit(1000000000));
    }
}
