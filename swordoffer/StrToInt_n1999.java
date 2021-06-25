package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月06日 9:25 下午
 */
public class StrToInt_n1999 {
    public static int strToInt(String str) {
        str=str.trim();
        if (str.length()==0) return 0;
        boolean tag=true;
        if (str.charAt(0)=='-'||str.charAt(0)=='+'){
            if (str.charAt(0)=='-') tag=false;
            str=str.substring(1);
        }
        int len=str.length();
        long res=0;
        for (int i=0;i<len;i++){
            if (str.charAt(i)>='0'&&str.charAt(i)<='9') res=res*10+str.charAt(i)-'0';
            else break;
            if (tag==false&&-res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (tag==true&&res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        if (tag==false) res=-res;
        return (int) res;
    }

    public static void main(String[] args) {
        String s="-2147483648";
        System.out.println(strToInt(s));
    }
}
