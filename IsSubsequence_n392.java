package leetcode;

/**
 * @author panhao
 * @date 2021年04月16日 7:59 下午
 */
public class IsSubsequence_n392 {
    public boolean isSubsequence(String s ,String t){
        int lens=s.length(),lent=t.length();
        if (lens==0) return true;
        if (lens>lent) return false;
        if (lens==lent) return s.equals(t);
        int i=0,j=0;
        while(i<lens&&j<lent){
            if (s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==lens;
    }

    public static void main(String[] args) {
        String s="abc",t="ahbgdc";
        IsSubsequence_n392 isSubsequence_n392=new IsSubsequence_n392();
        System.out.println(isSubsequence_n392.isSubsequence(s,t));
    }
}
