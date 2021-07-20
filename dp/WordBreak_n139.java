package leetcode.dp;


import java.util.List;

/**
 * @program: first
 * @description: 单词拆分
 * @author: panhao
 * @date: 2021-07-18 09:51
 **/
public class WordBreak_n139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;
        for (int i=1;i<=len;i++){
            for (int j=i+1;j<=len;j++){
                
            }
        }




        return false;
    }

}
