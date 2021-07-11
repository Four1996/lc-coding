package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-11 10:32
 **/
public class CountPalindromicSubsequence_n5809 {
    public static int countPalindromicSubsequence(String s) {
        char[] chars = s.toCharArray();
        int len=chars.length;
        HashMap<Character,int[]> map=new HashMap<>();
        for (int i=0;i<len;i++){
            char c=chars[i];
            if (map.containsKey(c)){
                int[] pos = map.get(c);
                pos[1]=i;
                map.put(c,pos);
            }else{
                map.put(c,map.getOrDefault(c,new int[]{i,i}));
            }
        }
        int ans=0;
        for (int i=0;i<len;i++){
            char c=chars[i];
            if (map.containsKey(c)){
                int[] ints = map.get(c);
                if (ints[0]==ints[1]) continue;
                else{
                    Set<Character> set=new HashSet<>();
                    int st=ints[0];
                    int en=ints[1];
                    for (int j=st+1;j<en;j++){
                        set.add(chars[j]);
                    }
                    ans+=set.size();
                }
                map.remove(c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }
}
