package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年05月29日 10:30 下午
 */
public class CountGoodSubstrings_n5754 {
    public int countGoodSubstrings(String s) {
        int ans=0;
        for (int i=0;i<s.length()-2;i++){
            HashSet<Character> set=new HashSet<>();
            set.add(s.charAt(i));
            set.add(s.charAt(i+1));
            set.add(s.charAt(i+2));
            if (set.size()==3) ans++;
        }
        return ans;
    }
}
