package leetcode;

/**
 * @author panhao
 * @date 2021年04月18日 4:48 下午
 */
public class LengthOfLastWord_n58 {
    public int lengthOfLastWord(String s){
        s=s.trim();
        int len=s.length();
        if (len==0) return 0;
        String ans="";
        int i=len-1;
        while(s.charAt(i)!=' '){
            ans+=String.valueOf(s.charAt(i));
            i--;
            if (i<0) break;
        }
        return ans.length();
    }

    public static void main(String[] args) {
        String s=" ";
        LengthOfLastWord_n58 l=new LengthOfLastWord_n58();
        System.out.println(l.lengthOfLastWord(s));

    }
}
