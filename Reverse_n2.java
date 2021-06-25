package leetcode;

/**
 * @author panhao
 * @date 2021年04月12日 3:53 下午
 */
public class Reverse_n2 {
    public static int reverse(int x) {
        long a = x;
        if (a < 0) a = -a;
        String str = String.valueOf(a);
        int len = str.length();
        String ansstr = "";
        for (int j = len - 1; j >= 0; --j) {
            ansstr += str.charAt(j);
        }
        long ans = Long.valueOf(ansstr);
        if (x > 0) return ans < Math.pow(2, 31) - 1 ? (int) ans : 0;
        return -ans > -Math.pow(2, 31) ? (int) -ans : 0;
    }

    public static int reverse_2(int x) {
        long a=x;
        if (a<0) a=-a;
        int ans = 0;
        String str=String.valueOf(a);
        int len=str.length();
        while (a !=0) {
            if ((ans+a%10*Math.pow(10,len-1)>Math.pow(2, 31) - 1 )&&x>0) return 0;
            if ((-(ans+a%10*Math.pow(10,len-1))<-Math.pow(2, 31))&&x<0) return 0;
            ans+=a%10*Math.pow(10,len---1);
            a=a/10;
        }
        if (x > 0) return ans;
        return -ans;
    }

    public static void main(String[] args) {
        int x = -123;
        int x2=-2147483648;
        System.out.println(reverse_2(x2));
    }
}
