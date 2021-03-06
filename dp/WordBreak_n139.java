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
public class WordBreak_n139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String substring = s.substring(i, j);
                if (dp[i] && set.contains(substring)) {
                    dp[j] = true;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s="a";
        List<String> list=new ArrayList<>(Arrays.asList("a"));
        System.out.println(wordBreak(s,list));
    }

}
