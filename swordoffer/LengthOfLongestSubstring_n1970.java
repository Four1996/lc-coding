package leetcode.swordoffer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年06月03日 6:47 下午
 */
public class LengthOfLongestSubstring_n1970 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int[] dp=new int[s.length()+1];
        int ans=0;
        int len;
        int start=0;
        for (int i=1;i<=s.length();i++){
            if (map.containsKey(s.charAt(i-1))){
                int idx=map.get(s.charAt(i-1));
                map.put(s.charAt(i-1),i);
                if (idx<start){
                    dp[i]=dp[i-1]+1;
                }
                else{
                    start=idx+1;
                    len=i-idx;
                    dp[i]=len;
                }
            }else{
                map.put(s.charAt(i-1),i);
                dp[i]=dp[i-1]+1;
            }
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(new LengthOfLongestSubstring_n1970().lengthOfLongestSubstring(s));
    }
}
