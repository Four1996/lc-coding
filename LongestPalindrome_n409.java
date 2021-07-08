package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: first
 * @description: 最长回文串
 * @author: panhao
 * @date: 2021-07-08 20:35
 **/
public class LongestPalindrome_n409 {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> count=new HashMap<>();
        char[] chars = s.toCharArray();
        int len=s.length();
        for (int i=0;i<len;i++){
            count.put(chars[i],count.getOrDefault(chars[i],0)+1);
        }
        int maxodd=0;
        int ans=0;
        for (Map.Entry<Character, Integer> entry:count.entrySet()){
            int value = entry.getValue();
            if (value%2==0) ans+=value;
            else {
                maxodd=Math.max(maxodd,value);
                ans+=value-1;
            }
        }
        return ans==len?ans:ans+1;
    }
}
