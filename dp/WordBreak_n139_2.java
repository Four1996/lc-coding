package leetcode.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: first
 * @description: 单词拆分
 * @author: panhao
 * @date: 2021-07-18 09:51
 **/
public class WordBreak_n139_2 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i=0;i<len;i++){
            if (!dp[i]){
                continue;
            }
            for (String s1 : wordDict) {
                if (s1.length()+i<=len&&s.startsWith(s1,i)){
                    dp[i+s1.length()]=true;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s="leetcode";
        List<String> list=new ArrayList<>(Arrays.asList("leet","code"));
        System.out.println(wordBreak(s,list));
    }

}
