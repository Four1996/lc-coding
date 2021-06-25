package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月16日 7:59 下午
 */
public class IsSubsequence_n392_2 {
    public boolean isSubsequence(String s ,String t){
        int lens=s.length(),lent=t.length();
        if (lens==0) return true;
        if (lens>lent) return false;
        if (lens==lent) return s.equals(t);
        int[][] dp=new int[lent+1][26];
        Arrays.fill(dp[lent],lent);
        for (int i=lent-1;i>=0;i--){
            for (int j=0;j<26;j++){
//                char b=t.charAt(i);
                if (t.charAt(i)=='a'+j) dp[i][j]=i;
                else dp[i][j]=dp[i+1][j];
            }
        }
        for(int i=0,k=0;i<lens;i++){
//            s.charAt(i)-'a'求出当前字母，并查询在dp数组中的该字母第一次出现的位置。
            if (dp[k][s.charAt(i)-'a']==lent) return false;
            else k=dp[k][s.charAt(i)-'a']+1;//执行到这里说明不满足dp[k][s.charAt(i)-'a']==lent,即该字母存在在dp数组中，
            // 也就是存在在t字符串中，然后从其所在t中的位置的下一行开始继续匹配（为什么从下一行呢，因为上边已经满足了dp[k][s.charAt(i)-'a']==lent
            // 说明该字符已经匹配成功了）
        }
        return true;
    }

    public static void main(String[] args) {
        String s="adc",t="ahbgdc";
        IsSubsequence_n392_2 isSubsequence_n392=new IsSubsequence_n392_2();
        System.out.println(isSubsequence_n392.isSubsequence(s,t));
    }
}
