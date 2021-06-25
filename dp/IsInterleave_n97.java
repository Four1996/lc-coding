package leetcode.dp;

/**
 * @author panhao
 * @date 2021年06月01日 10:44 上午
 */
public class IsInterleave_n97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1=s1.length(),l2=s2.length(),l3=s3.length();
        if (l3!=l1+l2) return false;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        int cur1=0,cur2=0;
        for (int i=0;i<s3.length();i++){

        }
        return true;
    }
}
