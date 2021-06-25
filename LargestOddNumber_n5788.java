package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-06-20 10:33
 **/
public class LargestOddNumber_n5788 {
    public static String largestOddNumber(String num) {
        String ans="";
        int len=num.length();
        for (int i=len-1;i>=0;i--){
            char c=num.charAt(i);
            int n=c-'0';
            if (n%2==1){
                ans=num.substring(0,i+1);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String num="52";
        System.out.println(largestOddNumber(num));
    }
}
