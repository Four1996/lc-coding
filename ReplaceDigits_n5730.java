package leetcode;

/**
 * @author panhao
 * @date 2021年05月01日 10:30 下午
 */
public class ReplaceDigits_n5730 {
    static String ans="";
    public static String replaceDigits(String s) {
        shift(s);
        return ans;
    }
    public static void shift(String s){
        int len=s.length();
        for (int i=0;i<len;i++){
            if (i%2==0) ans+=String.valueOf(s.charAt(i));
            else{
                int n=Integer.valueOf(s.charAt(i))-48;
                char cc= (char) (s.charAt(i-1)+n);
                ans+=String.valueOf(cc);
            }
        }
    }

    public static void main(String[] args) {
        String s="a1b2c3d4e";
        System.out.println(replaceDigits(s));
    }
}
