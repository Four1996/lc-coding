package leetcode;

/**
 * @author panhao
 * @date 2021年04月12日 4:45 下午
 */
public class IsPalindrome_n9 {
    public static boolean isPalindrome(int x){
        long a=x;
        if (a<0) return false;
        int reverse=reverse((int) a);
        return reverse==x;
    }
    public static int reverse(int a){
        long tail=a;
        String str=String.valueOf(tail);
        int len=str.length();
        int ans=0;
        while (tail!=0){
            if((ans+tail%10*Math.pow(10,len-1)>Math.pow(2,31)-1)&&a>0) return 0;
            ans+=tail%10*Math.pow(10,len---1);
            tail/=10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x=-101;
        System.out.println(isPalindrome(x));
    }
}
